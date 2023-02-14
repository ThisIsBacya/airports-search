package org.example;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static List<String> searchCsvLine(int searchColumnIndex, String searchString) throws IOException {
        String regex = searchString + "[a-zA-Z. ]+";
        Pattern pattern = Pattern.compile(regex);
        BufferedReader br = new BufferedReader(new FileReader("E://IdeaProjects//airports-search//airports.csv"));
        String line;
        List<String> rows = new ArrayList<>();
        long time = System.currentTimeMillis();
        while ( (line = br.readLine()) != null ) {
            String[] values = line.split(",");
            Matcher matcher = pattern.matcher(values[searchColumnIndex + 1]);
            if (matcher.find()) {
                rows.add(values[searchColumnIndex].substring(matcher.start(), matcher.end()));
            }
        }
        System.out.println("Количество найденных строк: " + rows.size());
        System.out.println("Времени затрачено: " + (System.currentTimeMillis() - time) + "ms");
        br.close();
        return rows;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Введите строку: ");
            String text = scanner.nextLine();
            System.out.println(searchCsvLine(1, text));
            if (text.equals("!quit")) {
                System.exit(0);
            }
        } while (true);
    }
}