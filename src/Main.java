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
        int random_row = random.nextInt(rows_number);
        int random_column = random.nextInt(columns_number);
        boolean horizontal_placing = random.nextBoolean();

        placeShip(fill_map, random_row, random_column, 3, horizontal_placing, rows_number, columns_number, random);
        random_row = random.nextInt(rows_number);
        random_column = random.nextInt(columns_number);
        horizontal_placing = random.nextBoolean();

        placeShip(fill_map, random_row, random_column, 2, horizontal_placing, rows_number, columns_number, random);
        random_row = random.nextInt(rows_number);
        random_column = random.nextInt(columns_number);
        horizontal_placing = random.nextBoolean();

        placeShip(fill_map, random_row, random_column, 2, horizontal_placing, rows_number, columns_number, random);
        random_row = random.nextInt(rows_number);
        random_column = random.nextInt(columns_number);
        horizontal_placing = random.nextBoolean();


        return fill_map;
    }

    public static void placeShip(int[][] map, int start_row, int start_column, int size, boolean horizontal, int rows, int columns, Random random) {
        while (start_row + size > rows && start_column + size > columns){
            start_row = random.nextInt(rows);
            start_column = random.nextInt(columns);
            horizontal = random.nextBoolean();
        }

        if (horizontal) {
            for (int i = 0; i < size; i++){
                map[start_row][start_column + i] = 1;
            }
        } else{
            for (int i = 0; i < size; i++){
                map[start_row + i][start_column] = 1;
            }
        }
    }
}