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

        String dateRegex = "^(\\d{2}/\\d{2}/\\d{4}|\\d{2}\\.\\d{2}\\.\\d{4}|\\d{2}\\.\\d{4}|\\d{4}|\\d{2}\\.\\d{2}\\.\\d{4} \\d{2}:\\d{2}:\\d{2})$";

        Pattern pattern = Pattern.compile(dateRegex);
        Matcher matcher = pattern.matcher(inputDate);

        if (matcher.matches()) {
            SimpleDateFormat outputFormat = new SimpleDateFormat("d - E, M - MM, y - yyyy", Locale.ENGLISH);
            SimpleDateFormat inputFormat;
            String resultType;

            if (inputDate.length() == 4) {
                inputFormat = new SimpleDateFormat("yyyy", Locale.ENGLISH);
                resultType = "год";
            } else if (inputDate.length() == 7 && inputDate.contains(".")) {
                inputFormat = new SimpleDateFormat("MM.yyyy", Locale.ENGLISH);
                resultType = "месяц - MM, год - yyyy";
            } else if (inputDate.length() == 7) {
                inputFormat = new SimpleDateFormat("MM.yyyy", Locale.ENGLISH);
                resultType = "месяц - MM, год - yyyy";
            } else if (inputDate.length() == 10) {
                inputFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
                resultType = "день - E, месяц - MM, год - yyyy";
            } else {
                inputFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
                resultType = "день - E, месяц - MM, год - yyyy";
            }

            try {
                Date date = inputFormat.parse(inputDate);
                String formattedDate = outputFormat.format(date);

                System.out.println("Введено: " + inputDate);
                if (resultType.equals("год") || resultType.equals("месяц - MM, год - yyyy")) {
                    System.out.println("Результат (" + resultType + "): " + inputDate);
                } else {
                    System.out.println("Результат: " + formattedDate);
                }
            } catch (java.text.ParseException e) {
                System.out.println("Ошибка при парсинге даты.");
            }
        } else {
            System.out.println("Введенная дата и время не соответствуют заданному формату.");
        }
    }
}


