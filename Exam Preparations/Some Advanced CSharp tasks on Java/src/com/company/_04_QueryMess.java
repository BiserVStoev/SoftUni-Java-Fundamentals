package com.company;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _04_QueryMess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("([^&=?]*)=([^&=]*)");

        while (!input.equals("END")){
            LinkedHashMap<String, List<String>> currentQuery = new LinkedHashMap<>();



            String split = input.replaceAll("%20", " ").replaceAll("\\+", " ").replaceAll("\\s+", " ").trim();


            Matcher matcher = pattern.matcher(split);

            while (matcher.find()){
                if (!currentQuery.containsKey(matcher.group(1).trim())){
                    currentQuery.put(matcher.group(1).trim(), new ArrayList<>());
                }
                currentQuery.get((matcher.group(1).trim())).add(matcher.group(2).trim());
            }

            for (String query : currentQuery.keySet()){
                System.out.printf("%s=[", query);
                String values = "";
                for (String value : currentQuery.get(query)){
                    if (!value.equals("")){
                        values += value + ", ";
                    }
                }
                System.out.printf("%s]", values.substring(0, values.length() - 2));
            }
            System.out.println();

            input = scanner.nextLine();
        }
    }
}
