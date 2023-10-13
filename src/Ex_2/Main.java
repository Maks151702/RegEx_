package Ex_2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите дату и время: ");
        String inputDate = scanner.nextLine();
        scanner.close();

        String dateRegex = "^(\\d{2}\\/\\d{2}\\/\\d{4} \\d{2}:\\d{2}:\\d{2}|\\d{2}\\.\\d{2}\\.\\d{4} \\d{2}:\\d{2}|\\d{2}\\.\\d{2}\\.\\d{4}|\\d{4})$";

        Pattern pattern = Pattern.compile(dateRegex);

        Matcher matcher = pattern.matcher(inputDate);

        // Проверяем, соответствует ли введенная дата регулярному выражению
        if (matcher.matches()) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);

            try {
                Date date = sdf.parse(inputDate);
                SimpleDateFormat outputFormat = new SimpleDateFormat("d - E, M - MM, y - yyyy, HH часов mm минут ss секунд", Locale.ENGLISH);
                String formattedDate = outputFormat.format(date);

                System.out.println("Введено: " + inputDate);
                System.out.println("Результат: " + formattedDate);
            } catch (java.text.ParseException e) {
                System.out.println("Ошибка при парсинге даты.");
            }
        } else {
            System.out.println("Введенная дата и время не соответствуют заданному формату.");
        }
    }
}
