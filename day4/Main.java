import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);
        List<char[]> grid = new ArrayList<>();

        int count = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("")) continue;

            grid.add(line.toCharArray());
        }

        for (int i = 0; i < grid.size(); i++) {
            char[] line = grid.get(i);
            for (int j = 0; j < line.length; j++) {
                char currentChar = line[j];

                if (currentChar == 'X') {
                    if (isUp(grid, i, j)) {
                        count++;
                    }
                    if (isDown(grid, i, j)) {
                        count++;
                    }
                    if (isLeft(grid, i, j)) {
                        count++;
                    }
                    if (isRight(grid, i, j)) {
                        count++;
                    }
                    if (isNE(grid, i, j)) {
                        count++;
                    }
                    if (isSE(grid, i, j)) {
                        count++;
                    }
                    if (isSW(grid, i, j)) {
                        count++;
                    }
                    if (isNW(grid, i, j)) {
                        count++;
                    }
                }
            }
        }

        scanner.close();
        System.out.println(count);
    }

    private static boolean isUp(List<char[]> grid, int row, int col) {
        return getFrom(grid, row, col) == 'X' &&
            getFrom(grid, row - 1, col) == 'M' &&
            getFrom(grid, row - 2, col) == 'A' &&
            getFrom(grid, row - 3, col) == 'S'; 
    }

    private static boolean isDown(List<char[]> grid, int row, int col) {
        return getFrom(grid, row, col) == 'X' &&
            getFrom(grid, row + 1, col) == 'M' &&
            getFrom(grid, row + 2, col) == 'A' &&
            getFrom(grid, row + 3, col) == 'S'; 
    }

    private static boolean isLeft(List<char[]> grid, int row, int col) {
        return getFrom(grid, row, col) == 'X' &&
            getFrom(grid, row, col - 1) == 'M' &&
            getFrom(grid, row, col - 2) == 'A' &&
            getFrom(grid, row, col - 3) == 'S';
    }

    private static boolean isRight(List<char[]> grid, int row, int col) {
        return getFrom(grid, row, col) == 'X' &&
            getFrom(grid, row, col + 1) == 'M' &&
            getFrom(grid, row, col + 2) == 'A' &&
            getFrom(grid, row, col + 3) == 'S';
    }

    private static boolean isNE(List<char[]> grid, int row, int col) {
        return getFrom(grid, row, col) == 'X' &&
            getFrom(grid, row - 1, col + 1) == 'M' &&
            getFrom(grid, row - 2, col + 2) == 'A' &&
            getFrom(grid, row - 3, col + 3) == 'S';
    }

    private static boolean isSE(List<char[]> grid, int row, int col) {
        return getFrom(grid, row, col) == 'X' &&
            getFrom(grid, row + 1, col + 1) == 'M' &&
            getFrom(grid, row + 2, col + 2) == 'A' &&
            getFrom(grid, row + 3, col + 3) == 'S';
    }

    private static boolean isSW(List<char[]> grid, int row, int col) {
        return getFrom(grid, row, col) == 'X' &&
            getFrom(grid, row + 1, col - 1) == 'M' &&
            getFrom(grid, row + 2, col - 2) == 'A' &&
            getFrom(grid, row + 3, col - 3) == 'S';
    }

    private static boolean isNW(List<char[]> grid, int row, int col) {
        return getFrom(grid, row, col) == 'X' &&
            getFrom(grid, row - 1, col - 1) == 'M' &&
            getFrom(grid, row - 2, col - 2) == 'A' &&
            getFrom(grid, row - 3, col - 3) == 'S';
    }

    private static char getFrom(List<char[]> grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.size() || j >= grid.get(i).length) {
            return '.';
        }
        return grid.get(i)[j];
    }
}
