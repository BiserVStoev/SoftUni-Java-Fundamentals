package com.company;

import java.util.*;

public class _04_LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int logsCount =  Integer.parseInt(scanner.nextLine());

        TreeMap<String, TreeMap<String,Integer>> logs = new TreeMap<>();

        for (int i = 0; i < logsCount; i++) {

            String[] currentInput = scanner.nextLine().split(" ");
            String ip = currentInput[0];
            String currentUser = currentInput[1];
            Integer time = Integer.parseInt(currentInput[2]);

            if (!logs.containsKey(currentUser)){
                logs.put(currentUser, new TreeMap<>());
                logs.get(currentUser).put(ip, time);
            }else if (logs.get(currentUser).get(ip) == null){
                logs.get(currentUser).put(ip, time);
            }else{
                int newMinutes = logs.get(currentUser).get(ip) + time;
                logs.get(currentUser).put(ip, newMinutes);
            }
        }

        for (String name : logs.keySet()){
            System.out.print(name + ": ");
            int duration = 0;
            for (String ip : logs.get(name).keySet()){
                duration += logs.get(name).get(ip);
            }

            System.out.print(duration + " ");

            System.out.println(logs.get(name).keySet());


        }
    }
}
