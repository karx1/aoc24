import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

        ArrayList<ArrayList<String>> incorrect = new ArrayList<>();
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

            if (!good) {
                incorrect.add(pages);
            }
        }

        Comparator<String> c = new RuleComparator(rules);
        for (ArrayList<String> pages : incorrect) {
            Collections.sort(pages, c);

            int mid = pages.size() / 2;
            sum += Integer.parseInt(pages.get(mid));
        }

        scanner.close();
        System.out.println(sum);
    }

    private static class RuleComparator implements Comparator<String> {
        private ArrayList<String> rules;

        public RuleComparator(ArrayList<String> r) {
            rules = r;
        }

        public int compare(String a, String b) {
            for (String rule : rules) {
                String[] s = rule.split("\\|");

                String first = s[0];
                String second = s[1];

                if (first.equals(a) && second.equals(b)) {
                    return -1;
                } else if (first.equals(b) && second.equals(a)) {
                    return 1;
                }
            }

            return 0;
        }
    }
}
