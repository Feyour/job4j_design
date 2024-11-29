package ru.job4j.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream input = new FileInputStream("data/even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = input.read()) != -1) {
                text.append((char) read);
            }
            String str = text.toString();
            Arrays.stream(str.split("\n"))
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .filter(n -> n % 2 == 0)
                    .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
