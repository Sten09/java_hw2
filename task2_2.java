package java_project.hw2;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class task2_2 {
    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Реализовать простой калькулятор ");
            System.out.print("Ввведите первое число: ");
            float oneNumber = in.nextFloat();
            writeLog("Ввели первое число: "  + oneNumber);
            System.out.print("Ввведите второе число: ");
            float twoNumber = in.nextFloat();
            writeLog("Ввели второе число: "  + twoNumber);
            System.out.print("Укажите арифметическую операцию (+, -, /, *): ");
            String op = in.next();
            writeLog("Выбрана арифметическая операция: "  + op);
            System.out.printf("Ответ: %f", calc(oneNumber, twoNumber, op));
            writeLog("Получен ответ: "  + calc(oneNumber, twoNumber, op));

        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public static float calc(float n1, float n2, String op) {
        float result = 0;
        switch (op) {
            case "+":
                result = n1 + n2;
                break;

            case "-":
                result = n1 - n2;
                break;

            case "/":
                result = n1 / n2;
                break;

            case "*":
                result = n1 * n2;
                break;

            default:
                break;

        }

        return result;

    }

    public static void writeLog(String msg) {
        // задаем формат даты и времени
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.uuuu HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        // открываем файл для добавления строк
        try (PrintWriter p = new PrintWriter(new FileOutputStream("logCalc.txt", true))) {
            // пишем в лог
            p.println(dtf.format(now) + "\t\t" + msg);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }
}
