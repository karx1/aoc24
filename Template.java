import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Template {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);

        int count = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("")) continue;
            Scanner lineScanner = new Scanner(line);

            lineScanner.close();
        }

        scanner.close();
        System.out.println(count);
    }
}
