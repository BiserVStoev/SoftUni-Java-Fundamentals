package com.company;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _04_UserLogs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("IP=(.+)\\smessage=.+\\suser=(\\w{3,50})");

        TreeMap<String, LinkedHashMap<String, Integer>> userLogs = new TreeMap<>();

        String user = "";
        String ip = "";

        while (!input.equals("end")){

            Matcher matcher = pattern.matcher(input);

            while (matcher.find()){

                user = matcher.group(2);
                ip = matcher.group(1);
            }

            if (!userLogs.containsKey(user)){
                userLogs.put(user, new LinkedHashMap<>());
                userLogs.get(user).put(ip, 1);
            }else if (userLogs.get(user).get(ip) == null){
                userLogs.get(user).put(ip, 1);
            }else {
                int previousCount = userLogs.get(user).get(ip);
                userLogs.get(user).put(ip, previousCount + 1);
            }

            input = scanner.nextLine();
        }

        for (String name : userLogs.keySet()){
            System.out.printf("%s:\n", name);

            String output = "";

            for (String ipAddress : userLogs.get(name).keySet()){
                output += String.format("%s => %d, ", ipAddress, userLogs.get(name).get(ipAddress));
            }
            System.out.println(output.substring(0, output.length() - 2) + ".");
        }
    }
}
