import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_SoftuniDefenceSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double totalLitres = 0;

        Pattern pattern = Pattern.compile("([A-Z][a-z]+).*?([A-Z][a-z]*?[A-Z]).*?(\\d+L)");

        while (!input.equals("OK KoftiShans")){

            Matcher matcher = pattern.matcher(input);

            while (matcher.find()){
                System.out.printf("%s brought %d liters of %s!\n", matcher.group(1), Integer.parseInt(matcher.group(3).substring(0, matcher.group(3).length() - 1)), matcher.group(2).toLowerCase());
                totalLitres += 0.001 * Integer.parseInt(matcher.group(3).substring(0, matcher.group(3).length() - 1));
            }

            input = scanner.nextLine();
        }

        System.out.printf("%.3f softuni liters", totalLitres);
    }
}
