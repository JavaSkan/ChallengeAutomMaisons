import java.util.Scanner;

public class Main {

    private static boolean isValid(int n)
    {
        if(!(n <= 1000000 && n >= 0))
        {
            System.out.println("/!\\ La valeur que vous avez donné est érronéé, cette dernière doit être comprise entre 0 et 10^6 (inclus) /!\\");
            return false;
        }
        return true;
    }

    private static int trueOrdonate(int o, char[][] grid)
    {
        return grid.length-1-o;
    }

    private static int[][] convertOrdiantes(int[][] cos,char[][] grid)
    {
        int[][] newcos = new int[cos.length][cos[0].length];

        for(int i = 0; i < cos.length;i++)
        {
            for(int j = 0; j < cos[i].length;j++)
            {
                newcos[i][j] = cos[i][j];
            }
        }

        for(int i = 0; i < cos.length;i++)
        {
            newcos[i][1] = trueOrdonate(cos[i][1],grid);
        }
        return newcos;
    }

    private static int[][] getCoordinate(int num_h)
    {
        int[][] coordinates = new int[num_h][2];
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < num_h; i++)
        {
            int x; //l'abscisse
            int y; //l'ordonnée

            do //pour l'abscisse
            {
                System.out.print("Donnez un l'abscisse de la maison n°"+(i+1)+": ");
                x = sc.nextInt();
            }while(!isValid(x));
            coordinates[i][0] = x;

            do //pour l'ordonnée
            {
                System.out.print("Donnez un l'ordonnée de la maison n°"+(i+1)+": ");
                y = sc.nextInt();
            }while(!isValid(y));
            coordinates[i][1] = y;

        }

        return coordinates;
    }

    private static int sAbscissa(int[][] cos)
    {
        int sA = cos[0][0];

        for(int i = 0 ; i < cos.length; i++) {
            if(cos[i][0] < sA)
            {
                sA = cos[i][0];
            }
        }
        return sA;
    }

    private static int sOrdinate(int[][] cos)
    {
        int sO = cos[0][1];
        for(int i = 0 ; i < cos.length; i++) {
            if(cos[i][1] < sO)
            {
                sO = cos[i][1];
            }
        }
        return sO;
    }

    private static int bAbscissa(int[][] cos)
    {
        int bA = 0;
        for(int i = 0 ; i < cos.length; i++)
        {
            if (cos[i][0] > bA) {
                bA = cos[i][0];
            }
        }
        return bA;
    }

    private static int bOrdiante(int[][] cos)
    {
        int bO = 0;
        for(int i = 0 ; i < cos.length; i++) {
            if(cos[i][1] > bO)
            {
                bO = cos[i][1];
            }
        }
        return bO;
    }

    private static char[][] getCleanGrid(int[][] cos)
    {
        char[][] grid = new char[bOrdiante(cos)+2][bAbscissa(cos)+2];

        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                grid[i][j] = '-';
            }
        }

        return grid;
    }

    private static void displayGrid(char[][] grid)
    {
        System.out.println("-----------------------------");
        for(int i = 0; i < grid.length; i++)
        {
            System.out.print(grid.length-i-1+"[");
            for(int j = 0; j < grid[i].length; j++)
            {
                if(j == grid[i].length-1)
                {
                    System.out.print(grid[i][j]);
                }else
                {
                    System.out.print(grid[i][j]+" ");
                }
            }
            System.out.println("]");
        }
        for(int i = 0; i < grid[0].length; i++)
        {
            if(i == 0)
            {
                System.out.print("  "+i+" ");
            }else if(i > 0 && i < grid[0].length-1)
            {
                System.out.print(i+" ");
            }else if(i == grid[0].length-1)
            {
                System.out.print(i);
            }
        }
        System.out.println("\n-----------------------------");
    }

    private static void drawHouses(char[][] grid, int[][] cos)
    {
        int[][] newc = convertOrdiantes(cos,grid);
        for(int i = 0; i < cos.length; i++) //for each house coordinate
        {
            //grid[grid.length-cos[i][1]-1][cos[i][0]] = '#';
            grid[newc[i][1]][newc[i][0]] = '#';
        }
    }

    private static void drawFence(char[][] grid,int[][] cos)
    {
        int sO = sOrdinate(cos);
        int sA = sAbscissa(cos);
        int bO = bOrdiante(cos);
        int bA = bAbscissa(cos);

        for(int i = sA; i <= bA; i++)
        {
            for(int j = sO; j <= bO; j++)
            {
                if(grid[j][i] != '#')
                {
                    if(i == sA || i == bA)
                    {
                        grid[j][i] = '/';
                    }else
                    {
                        if(j == sO || j == bO)
                        {
                            grid[j][i] = '/';
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = 0; //nombre de maisons

        do{
            System.out.print("Combien de maisons voulez vous créer?: ");
            n = sc.nextInt();
        }while(!isValid(n));

        int[][] cos = getCoordinate(n);

        char[][] grid = getCleanGrid(cos);
        displayGrid(grid);

        System.out.println("Création des maisons ...");
        drawHouses(grid, cos);
        displayGrid(grid);

        System.out.println("Création de la clôture...");
        drawFence(grid, convertOrdiantes(cos,grid));
        displayGrid(grid);
    }
}
