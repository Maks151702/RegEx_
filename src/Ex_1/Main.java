package Ex_1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите адрес электронной почты: ");
        String email = scanner.nextLine();
        scanner.close();

        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";

        Pattern pattern = Pattern.compile(emailRegex);

        Matcher matcher = pattern.matcher(email);

        // Проверяем, соответствует ли введенный адрес электронной почты регулярному выражению
        if (matcher.matches()) {
            System.out.println("Введенный адрес электронной почты корректен.");
        } else {
            System.out.println("Введенный адрес электронной почты некорректен.");
        }
    }
}
