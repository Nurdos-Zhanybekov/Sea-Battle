import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int rows_number = 7;
        int columns_number = 7;
        int[][] show_map = map(rows_number, columns_number);

        for (int i = 0; i < rows_number; i++){
            for (int j = 0; j < columns_number; j++){
                System.out.print(show_map[i][j] + " ");
            }
            System.out.println();
        }

        enter_coordinates(show_map, rows_number, columns_number);
    }

    public static void greeting(String enter_player_name){
        System.out.println("Sea-Battle");

        ArrayList<String> players_list = new ArrayList<>();
        players_list.add(enter_player_name);
        System.out.println(players_list);
    }

    public static int[][] map(int rows_number, int columns_number){
        Random random = new Random();
        int[][] fill_map = new int[rows_number][columns_number];

        placeShip(fill_map, 3, rows_number, columns_number, random);

        placeShip(fill_map, 2, rows_number, columns_number, random);
        placeShip(fill_map, 2, rows_number, columns_number, random);

        placeShip(fill_map, 1, rows_number, columns_number, random);
        placeShip(fill_map, 1, rows_number, columns_number, random);
        placeShip(fill_map, 1, rows_number, columns_number, random);
        placeShip(fill_map, 1, rows_number, columns_number, random);

        return fill_map;
    }

    public static void placeShip(int[][] map, int size, int rows, int columns, Random random){
        boolean placed = false;

        while(!placed) {
            int random_row = random.nextInt(rows);
            int random_column = random.nextInt(columns);
            boolean horizontal_placing = random.nextBoolean();

            if (horizontal_placing) {
                if(random_column + size <= columns && noShipsAround(map, random_row, random_column, size, rows, columns, true)) {
                    for (int i = 0; i < size; i++) {
                        map[random_row][random_column + i] = 1;
                    }

                    placed = true;
                }
            } else {
                if(random_row + size <= rows && noShipsAround(map, random_row, random_column, size, rows, columns, false)) {
                    for (int i = 0; i < size; i++) {
                        map[random_row + i][random_column] = 1;
                    }

                    placed = true;
                }
            }
        }
    }

    public static boolean noShipsAround(int[][] map, int row, int column, int size, int rows, int columns, boolean horizontal){
        if(horizontal){
            if(column + size > columns) return false;
            
            for(int i = -1; i <= 1; i++){
                for(int j = -1; j <= size + 1; j++){
                    int r = row + i;
                    int c = column + j;

                    if(r >= 0 && r < rows && c >= 0 && c < columns && map[r][c] == 1){
                        return false;
                    }
                }
            }
        }else{
            if(row + size >= rows) return false;

            for(int i = -1; i <= size + 1; i++){
                for(int j = -1; j <= 1; j++){
                    int r = row + i;
                    int c = column + j;

                    if(r >= 0 && r < rows && c >= 0 && c < columns && map[r][c] == 1){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void enter_coordinates(int[][] map, int rows, int columns){
        Scanner scanner = new Scanner(System.in);
        int total_ships_cells = 11;
        int hit_ships = 0;

        while(hit_ships < total_ships_cells){
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if(x > 7 || x < 1 || y > 7 || y < 1){
                boolean invalid_input = true;

                while(invalid_input){
                    System.out.println("Invalid Input, try again");

                    x = scanner.nextInt();
                    y = scanner.nextInt();

                    if(x <= rows && x > 0 && y <= columns && y > 0){
                        invalid_input = false;
                    }
                }
            }

            if(map[x - 1][y - 1] == 1){
                map[x - 1][y - 1] = 2;
                clear_console(map, rows, columns);
                hit_ships++;
            }else if(map[x - 1][y - 1] == 0){
                map[x - 1][y - 1] = 3;
                clear_console(map, rows, columns);
            }
        }
    }

    public static void clear_console(int[][] map, int rows_number, int columns_number){
        for(int i = 0; i < 10; i++){
            System.out.println();
        }

        for (int i = 0; i < rows_number; i++){
            for (int j = 0; j < columns_number; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}