package Ex_4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите номер телефона (в формате 380xx): ");
        String phoneNumber = scanner.nextLine();
        scanner.close();

        if (isValidPhoneNumber(phoneNumber)) {
            System.out.println("Введенный номер телефона корректен.");
        } else {
            System.out.println("Введенный номер телефона некорректен.");
        }
    }

    // проверка корректности номера телефона
    private static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^380\\d{2}\\d{7}$");
    }
}

