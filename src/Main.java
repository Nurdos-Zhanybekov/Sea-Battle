import java.util.Random;

public class Main {
    public static void main(String[] args) {
        greeting();

        int rows_number = 7;
        int columns_number = 7;
        int[][] show_map = map(rows_number, columns_number);

        for (int i = 0; i < rows_number; i++){
            for (int j = 0; j < columns_number; j++){
                System.out.print(show_map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void greeting(){
        System.out.println("Sea-Battle");
    }

    public static int[][] map(int rows_number, int columns_number){
        Random random = new Random();
        int[][] fill_map = new int[rows_number][columns_number];

        for(int i = 0; i < rows_number; i++){
            for(int j = 0; j < columns_number; j++){
                fill_map[i][j] = random.nextInt(0, 2);
            }
        }

        return fill_map;
    }
}