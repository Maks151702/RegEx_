package Ex_3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();
        scanner.close();

        String passwordRegex = "^(?=.*[0-9])(?=.*[,./?])(?=.*[A-Z]).{8,}$";

        Pattern pattern = Pattern.compile(passwordRegex);

        Matcher matcher = pattern.matcher(password);

        // Проверяем, соответствует ли введенный пароль заданным правилам
        if (matcher.matches()) {
            System.out.println("Введенный пароль корректен.");
        } else {
            System.out.println("Введенный пароль не соответствует требованиям.");
        }
    }
}
