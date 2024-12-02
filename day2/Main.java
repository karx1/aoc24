import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);

        int count = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("")) continue;
            Scanner lineScanner = new Scanner(line);

            ArrayList<Integer> report = new ArrayList<>();
            while (lineScanner.hasNextInt()) {
                int num = lineScanner.nextInt();
                report.add(num);
            }

            for (int i = 0; i < report.size(); i++) {
                int num = report.remove(i);
                if ((isIncreasing(report) || isDecreasing(report)) && diffsGood(report)) {
                    count++;
                    break;
                }
                report.add(i, num);
            }

            lineScanner.close();
        }

        scanner.close();
        System.out.println(count);
    }

    private static boolean isIncreasing(ArrayList<Integer> report) {
        for (int i = 1; i < report.size(); i++) {
            int prev = report.get(i - 1);
            int curr = report.get(i);
            if (curr <= prev) {
                return false;
            }
        }

        return true;
    }

    private static boolean isDecreasing(ArrayList<Integer> report) {
        for (int i = 1; i < report.size(); i++) {
            int prev = report.get(i - 1);
            int curr = report.get(i);
            if (curr >= prev) {
                return false;
            }
        }

        return true;
    }

    private static boolean diffsGood(ArrayList<Integer> report) {
        for (int i = 1; i < report.size(); i++) {
            int prev = report.get(i -1);
            int curr = report.get(i);

            int diff = Math.abs(prev - curr);

            if (diff < 1 || diff > 3) {
                return false;
            }
        }

        return true;
    }
}
