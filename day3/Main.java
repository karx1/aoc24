import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        String contents = Files.readString(file.toPath());

        Pattern pattern = Pattern.compile("do\\(\\)|don't\\(\\)|mul\\((\\d+),(\\d+)\\)");

        int sum = 0;

        boolean enabled = true;
        Matcher matcher = pattern.matcher(contents);

        while (matcher.find()) {
            String match = matcher.group(0);
            if (match.equals("do()")) {
                enabled = true;
            } else if (match.equals("don't()")) {
                enabled = false;
            } else {
                if (enabled) {
                    int num1 = Integer.parseInt(matcher.group(1));
                    int num2 = Integer.parseInt(matcher.group(2));

                    sum += num1 * num2;
                }
            }
        }

        System.out.println(sum);
    }
}
