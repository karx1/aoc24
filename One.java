import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class One {
    public static void main(String[] args) throws IOException {
        File file = new File("one.txt");
        Scanner scanner = new Scanner(file);

        ArrayList<Integer> leftNums = new ArrayList<>();
        HashMap<Integer, Integer> freqs = new HashMap<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("")) continue;

            Scanner lineScanner = new Scanner(line);

            leftNums.add(lineScanner.nextInt());
            int num = lineScanner.nextInt();

            Integer current = freqs.get(num);
            current = current == null ? 1 : current + 1;
            freqs.put(num, current);

            lineScanner.close();
        }

        int score = 0;
        for (int i : leftNums) {
            if (freqs.containsKey(i)) {
                score += i * freqs.get(i);
            }
        }

        scanner.close();
        System.out.println(score);
    }
}
