import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class One {
    public static void main(String[] args) throws IOException {
        File file = new File("one.txt");
        Scanner scanner = new Scanner(file);

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("")) continue;

            Scanner lineScanner = new Scanner(line);

            list1.add(lineScanner.nextInt());
            list2.add(lineScanner.nextInt());

            lineScanner.close();
        }

        Collections.sort(list1);
        Collections.sort(list2);

        int sum = 0;
        for (int i = 0; i < list1.size(); i++) {
            sum += Math.abs(list1.get(i) - list2.get(i));
        }

        scanner.close();
        System.out.println(sum);
    }
}
