import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);

        ArrayList<String> rules = new ArrayList<>();

        int sum = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isBlank()) break;
            rules.add(line);
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isBlank()) continue;

            ArrayList<String> pages = new ArrayList<>();
            for (String page : line.split(",")) {
                pages.add(page);
            }

            boolean good = true;

            for (String rule : rules) {
                String[] s = rule.split("\\|");

                int firstIndex = pages.indexOf(s[0]);
                int secondIndex = pages.indexOf(s[1]);

                if (!(firstIndex < secondIndex || firstIndex == -1 || secondIndex == -1)) {
                    good = false;
                    break;
                }
            }

            if (good) {
                int mid = pages.size() / 2;
                sum += Integer.parseInt(pages.get(mid));
            }
        }

        scanner.close();
        System.out.println(sum);
    }
}
