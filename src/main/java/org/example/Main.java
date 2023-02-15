package org.example;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static List<String> searchCsvLine(int searchColumnIndex, String searchString) throws IOException {
        String regex = searchString + "[a-zA-Z. ]+";
        Pattern pattern = Pattern.compile(regex);
        BufferedReader br = new BufferedReader(new FileReader("airports.csv"));
        String line;
        List<String> rows = new ArrayList<>();
        long time = System.currentTimeMillis();
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            Matcher matcher = pattern.matcher(values[searchColumnIndex]);
            if (matcher.find()) {
                rows.add(values[1] + " " + Arrays.toString(values) + "\n");
            }
        }
        System.out.println("Количество найденных строк: " + rows.size());
        System.out.println("Времени затрачено: " + (System.currentTimeMillis() - time) + "ms");
        br.close();
        return rows;
    }

    public static void main(String[] args) throws IOException {
        int col = Integer.parseInt(args[0]);
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Введите строку: ");
            String text = scanner.nextLine();
            System.out.println(searchCsvLine(col, text));
            if (text.equals("!quit")) {
                System.exit(0);
            }
        } while (true);
    }
}