import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);
        Pattern pattern = Pattern.compile("mul\\(\\d+,\\d+\\)");

        int sum = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                String instruction = matcher.group();
                instruction = instruction.substring(4); 
                instruction = instruction.replace(",", " ");
                instruction = instruction.substring(0, instruction.length() - 1);

                Scanner instScanner = new Scanner(instruction);
                int num1 = instScanner.nextInt();
                int num2 = instScanner.nextInt();
                sum += num1 * num2;

                instScanner.close();
            }
        }


        scanner.close();
        System.out.println(sum);
    }
}
