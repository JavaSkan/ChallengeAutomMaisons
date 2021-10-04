import java.util.Scanner;

public class Main {

    private static boolean isValid(int n)
    {
        //TODO
    }

    private static int trueOrdonate(int o, char[][] grid)
    {
        //TODO
    }

    private static int[][] convertOrdiantes(int[][] cos,char[][] grid)
    {
        //TODO
    }

    private static int[][] getCoordinate(int num_h)
    {
        //TODO
    }

    private static int sAbscissa(int[][] cos)
    {
        //TODO
    }

    private static int sOrdinate(int[][] cos)
    {
        //TODO
    }

    private static int bAbscissa(int[][] cos)
    {
        //TODO
    }

    private static int bOrdiante(int[][] cos)
    {
        //TODO
    }

    private static char[][] getCleanGrid(int[][] cos)
    {
        //TODO
    }

    private static void displayGrid(char[][] grid)
    {
        //TODO
    }

    private static void drawHouses(char[][] grid, int[][] cos)
    {
        //TODO
    }

    private static void drawFence(char[][] grid,int[][] cos)
    {
        //TODO
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
