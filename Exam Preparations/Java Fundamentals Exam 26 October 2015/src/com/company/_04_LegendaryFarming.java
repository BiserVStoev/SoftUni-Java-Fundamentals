package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _04_LegendaryFarming {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        TreeMap<String, Integer> keyMaterials = new TreeMap<>();

        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        TreeMap<String, Integer> junk = new TreeMap<>();

        Pattern pattern = Pattern.compile("\\d+\\s[a-zA-z\\-]+");

        List<String> usefullMaterials = Arrays.asList("shards", "fragments", "motes");

        boolean obtained = false;
        while (!input.equals("")) {

            Matcher matcher = pattern.matcher(input);


            while (matcher.find()) {

                int quantity = Integer.parseInt(matcher.group().split(" ")[0]);
                String material = matcher.group().split(" ")[1].toLowerCase();

                if (usefullMaterials.contains(material)) {

                    int previousQuantity = keyMaterials.get(material);
                    if (keyMaterials.get(material) + quantity >= 250) {
                        keyMaterials.put(material, (quantity + previousQuantity - 250));
                        if (material.equals("shards")){
                            System.out.println("Shadowmourne obtained!");
                        }else if (material.equals("fragments")){
                            System.out.println("Valanyr obtained!");
                        }else if (material.equals("motes")){
                            System.out.println("Dragonwrath obtained!");
                        }
                        obtained = true;
                        break;
                    } else {
                        keyMaterials.put(material, quantity + previousQuantity);
                    }

                }else{
                    if (!junk.containsKey(material)) {
                        junk.put(material, quantity);
                    } else {
                        int previousQuantity = junk.get(material);
                        junk.put(material, quantity + previousQuantity);
                    }
                }
            }
            if (obtained){
                break;
            }

            input = scanner.nextLine();
        }

        keyMaterials.entrySet().stream()
                .sorted((key1, key2) -> key2.getValue().compareTo(key1.getValue()))
                .forEach(key -> System.out.println(key.getKey() + ": " + key.getValue()));

        for (String junkElement : junk.keySet()){

            System.out.println(junkElement + ": " + junk.get(junkElement));
        }

        }

}
