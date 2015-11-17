import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _04_LogParser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("\\{\"Project\":\\s*\\[\"(.+)\"],\\s*\"Type\":\\s*\\[\"(.+)\"],\\s*\"Message\":\\s*\\[\"(.+)\"]}");

        LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> projectMessages = new LinkedHashMap<>();

        HashMap<String, Integer> errors = new HashMap<>();

        TreeMap<String, LinkedHashMap<String, Integer>> projectValues = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {

                if (!projectMessages.containsKey(matcher.group(1))) {
                    projectMessages.put(matcher.group(1), new LinkedHashMap<>());
                    projectMessages.get(matcher.group(1)).put("Warning Messages", new ArrayList<>());
                    projectMessages.get(matcher.group(1)).put("Critical Messages", new ArrayList<>());

                    projectValues.put(matcher.group(1), new LinkedHashMap<>());
                    projectValues.get(matcher.group(1)).put("Total Errors:", 0);
                    projectValues.get(matcher.group(1)).put("Critical:", 0);
                    projectValues.get(matcher.group(1)).put("Warnings:", 0);
                }

                if (matcher.group(2).equals("Warning")) {
                    projectMessages.get(matcher.group(1)).get("Warning Messages").add(matcher.group(3));
                    int previousWarnings = projectValues.get(matcher.group(1)).get("Warnings:");
                    projectValues.get(matcher.group(1)).put("Warnings:", previousWarnings + 1);
                } else if (matcher.group(2).equals("Critical")) {
                    projectMessages.get(matcher.group(1)).get("Critical Messages").add(matcher.group(3));
                    int previousCriticals = projectValues.get(matcher.group(1)).get("Critical:");
                    projectValues.get(matcher.group(1)).put("Critical:", previousCriticals + 1);
                }

                int previousTotal = projectValues.get(matcher.group(1)).get("Total Errors:");
                projectValues.get(matcher.group(1)).put("Total Errors:", previousTotal + 1);
            }
            input = scanner.nextLine();
        }

        for (String name: projectValues.keySet()){
            errors.put(name, projectValues.get(name).get("Total Errors:"));
        }

        ArrayList<String> sortedProjects = new ArrayList<>();

        errors.entrySet().stream()
                .sorted((a, b) -> a.getKey().compareTo(b.getKey()))
                .sorted((a, b) -> b.getValue().compareTo(a.getValue())).forEach(c -> sortedProjects.add(c.getKey()));

        for (String name : sortedProjects) {
            System.out.println(name + ":");

            for (String value : projectValues.get(name).keySet()){
                System.out.println(value + " " + projectValues.get(name).get(value));
            }

            System.out.println("Critical Messages:");

            if (projectMessages.get(name).get("Critical Messages").size() == 0) {
                System.out.println("--->None");
            } else {
                ArrayList<String> criticalMessages = new ArrayList<>();
                for (int i = 0; i < projectMessages.get(name).get("Critical Messages").size(); i++) {

                    criticalMessages.add(projectMessages.get(name).get("Critical Messages").get(i));
                }

                Collections.sort(criticalMessages, new lengthFirstComparator());

                for (int i = 0; i < criticalMessages.size(); i++) {
                    System.out.println("--->" + criticalMessages.get(i));
                }

            }



            System.out.println("Warning Messages:");

            if (projectMessages.get(name).get("Warning Messages").size() == 0) {
                System.out.println("--->None");
            } else {
                ArrayList<String> warningMessages = new ArrayList<>();
                for (int i = 0; i < projectMessages.get(name).get("Warning Messages").size(); i++) {

                    warningMessages.add(projectMessages.get(name).get("Warning Messages").get(i));
                }

                Collections.sort(warningMessages, new lengthFirstComparator());
                for (int i = 0; i < warningMessages.size(); i++) {
                    System.out.println("--->" + warningMessages.get(i));
                }
            }

            System.out.println();

        }
    }

    public static class lengthFirstComparator implements Comparator<String> {
        public int compare(String o1, String o2) {
            if (o1.length()!=o2.length()) {
                return o1.length()-o2.length();
            }
            return o1.compareTo(o2);
        }
    }
}
