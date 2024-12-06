import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        ArrayList<ArrayList<Character>> grid = new ArrayList<>();
        Scanner scanner = new Scanner(file);

        int count = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("")) continue;
            Scanner lineScanner = new Scanner(line);

            ArrayList<Character> row = new ArrayList<>();

            for (char c : line.toCharArray()) {
                row.add(c);
            }

            grid.add(row);

            lineScanner.close();
        }

        int currentRow = 0;
        int currentCol = 0;
        
        for (int i = 0; i < grid.size(); i++) {
            ArrayList<Character> row = grid.get(i);
            for (int j = 0; j < row.size(); j++) {
                char c = row.get(j);
                if (c == '^') {
                    currentRow = i;
                    currentCol = j;
                    break;
                }
            }
        }

        Direction direction = Direction.UP;

        while (!isOutOfBounds(grid, currentRow, currentCol)) {
            switch (direction) {
                case UP:
                    if (getFromGrid(grid, currentRow - 1, currentCol) != '#') {
                        set(grid, currentRow, currentCol, 'X');
                        currentRow--;
                    } else {
                        direction = Direction.RIGHT;
                    }
                    break;
                case RIGHT:
                    if (getFromGrid(grid, currentRow, currentCol + 1) != '#') {
                        set(grid, currentRow, currentCol, 'X');
                        currentCol++;
                    } else {
                        direction = Direction.DOWN;
                    }
                    break;
                case DOWN:
                    if (getFromGrid(grid, currentRow + 1, currentCol) != '#') {
                        set(grid, currentRow, currentCol, 'X');
                        currentRow++;
                    } else {
                        direction = Direction.LEFT;
                    }
                    break;
                case LEFT:
                    if (getFromGrid(grid, currentRow, currentCol - 1) != '#') {
                        set(grid, currentRow, currentCol, 'X');
                        currentCol--;
                    } else {
                        direction = Direction.UP;
                    }
                    break;
            }

            System.out.println(currentRow + " " + currentCol);
        }

        for (int i = 0; i < grid.size(); i++) {
            ArrayList<Character> row = grid.get(i);
            for (int j = 0; j < row.size(); j++) {
                char c = row.get(j);
                if (c == 'X') {
                    count++;
                }
            }
        }


        scanner.close();
        System.out.println(count);
    }

    private static boolean isOutOfBounds(ArrayList<ArrayList<Character>> grid, int i, int j) {
        return i < 0 || j < 0 || i >= grid.size() || j >= grid.get(0).size();
    }

    private static enum Direction {
        UP, DOWN, LEFT, RIGHT;
    }

    private static char getFromGrid(ArrayList<ArrayList<Character>> grid, int i, int j) {
        if (isOutOfBounds(grid, i, j)) {
            return '.';
        } else {
            return grid.get(i).get(j);
        }
    }

    private static void set(ArrayList<ArrayList<Character>> grid, int i, int j, char c) {
        if (!isOutOfBounds(grid, i, j)) {
            grid.get(i).set(j, c);
        }
    }
}
