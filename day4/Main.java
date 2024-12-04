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

                if (currentChar == 'A') {
                    if (isX(grid, i, j)) {
                        count++;
                    }
                }
            }
        }

        scanner.close();
        System.out.println(count);
    }

    private static boolean isX(List<char[]> grid, int row, int col) {
        char tl = getFrom(grid, row - 1, col - 1);
        char tr = getFrom(grid, row - 1, col + 1);
        char bl = getFrom(grid, row + 1, col - 1);
        char br = getFrom(grid, row + 1, col + 1);

        return ((tl == 'M' && br == 'S') ||
            (tl == 'S' && br == 'M')) &&
            ((tr == 'M' && bl == 'S') ||
             (tr == 'S' && bl == 'M'));
    }

    private static char getFrom(List<char[]> grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.size() || j >= grid.get(i).length) {
            return '.';
        }
        return grid.get(i)[j];
    }
}
