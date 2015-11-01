package com.company;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _04_DragonArmy {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, TreeMap<String, LinkedHashMap<String, Integer>>> dragons = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        Pattern pattern = Pattern.compile("([A-Z][a-zA-Z]+)\\s([A-Z][a-zA-Z]+)\\s(\\d+|null)\\s(\\d+|null)\\s(\\d+|null)");

        for (int i = 0; i < n; i++) {

            String input = scanner.nextLine();

            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {


                String color = matcher.group(1);
                String name = matcher.group(2);
                int damage = 0;
                if (matcher.group(3).equals("null")) {
                    damage = 45;
                } else {
                    damage = Integer.parseInt(matcher.group(3));
                }
                int health = 0;
                if (matcher.group(4).equals("null")) {
                    health = 250;
                } else {
                    health = Integer.parseInt(matcher.group(4));
                }
                int armor = 0;
                if (matcher.group(5).equals("null")) {
                    armor = 10;
                } else {
                    armor = Integer.parseInt(matcher.group(5));
                }

                if (!dragons.containsKey(color)) {
                    dragons.put(color, new TreeMap<>());
                    dragons.get(color).put(name, new LinkedHashMap<>());
                    dragons.get(color).get(name).put("damage", damage);
                    dragons.get(color).get(name).put("health", health);
                    dragons.get(color).get(name).put("armor", armor);
                } else if (!dragons.get(color).containsKey(name)) {
                    dragons.get(color).put(name, new LinkedHashMap<>());
                    dragons.get(color).get(name).put("damage", damage);
                    dragons.get(color).get(name).put("health", health);
                    dragons.get(color).get(name).put("armor", armor);
                }else{
                    dragons.get(color).get(name).put("damage", damage);
                    dragons.get(color).get(name).put("health", health);
                    dragons.get(color).get(name).put("armor", armor);
                }
            }

        }

        for (String color : dragons.keySet()){
            System.out.printf("%s::(", color);

            double averageDamage = 0;
            double averageHealth = 0;
            double averageArmor = 0;
            int count = 0;

            for (String name : dragons.get(color).keySet()){

                for (String attribute: dragons.get(color).get(name).keySet()){

                    if (attribute.equals("damage")){
                        averageDamage += dragons.get(color).get(name).get(attribute);
                    }else if (attribute.equals("health")){
                        averageHealth += dragons.get(color).get(name).get(attribute);
                    }else{
                        averageArmor += dragons.get(color).get(name).get(attribute);
                    }
                }
                count++;
            }


            System.out.printf("%.2f/%.2f/%.2f)\n", averageDamage / count,
                    averageHealth / count,
                    averageArmor / count);

            for (String name : dragons.get(color).keySet()){
                System.out.printf("-%s -> ", name);
                String eachDragonsAttributes = "";

                for (String attribute: dragons.get(color).get(name).keySet()){
                    eachDragonsAttributes += String.format("%s: %d, ", attribute, dragons.get(color).get(name).get(attribute));
                }

                System.out.println(eachDragonsAttributes.substring(0, eachDragonsAttributes.length() - 2));
            }
        }
    }
}
