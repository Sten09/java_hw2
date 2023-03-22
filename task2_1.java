package java_project.hw2;

import java.util.Random;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class task2_1 {
    public static void main(String[] args) {
        int[] arr = setRandomArray(5, 1, 99);
        System.out.println ("Задан массив: " + Arrays.toString(arr));
        writeLog("Массив:     " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("Результат сортировки: " + Arrays.toString(arr));
        writeLog("Результат:  " + Arrays.toString(arr));
    }

    static int[] setRandomArray(int size, int start, int end) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.ints(start, (end + 1)).findFirst().getAsInt();
        }
        return arr;
    }

    static void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    writeLog("сортировка: " + Arrays.toString(arr));
                }
            }
        }
    }

    public static void writeLog(String msg) {
        // задаем формат даты и времени
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.uuuu HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        // открываем файл для добавления строк
        try (PrintWriter p = new PrintWriter(new FileOutputStream("log.txt", true))) {
        // пишем в лог
            p.println(dtf.format(now) + "\t\t" + msg);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }
}
