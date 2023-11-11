import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите слово от 3 до 5 букв: ");
        String password = scanner.nextLine();

        System.out.print("Введите (с символом): ");
        String password2 = scanner.nextLine();
        scanner.close();

        String SymbolRegex = "^a.b$";

        String QuantRegex = "\\b\\w{3,5}\\b$";

        Pattern pattern2 = Pattern.compile(SymbolRegex);
        Pattern pattern = Pattern.compile(QuantRegex);

        Matcher matcher2 = pattern2.matcher(password2);
        Matcher matcher = pattern.matcher(password);


        // Проверяем, соответствует ли введенный пароль заданным правилам
        if (matcher.matches()) {
            System.out.println("Введенный c условием от 3 до 5 букв правильно.");
        } else {
            System.out.println("Введенный c условием от 3 до 5 букв не правильно.");
        }

        if (matcher2.matches()) {
            System.out.println("Введенный пароль с точкой правильно.");
        } else {
            System.out.println("Введенный пароль с точкой не правильно.");
        }

        String text = "LabA SpaCE";

        String regex = "[A-Z]";

        Pattern pattern3 = Pattern.compile(regex);

        Matcher matcher3 = pattern3.matcher(text);

        // Находим и выводим все заглавные буквы
        while (matcher3.find()) {
            String uppercaseLetter = matcher3.group();
            System.out.println(uppercaseLetter);
        }
    }
}
