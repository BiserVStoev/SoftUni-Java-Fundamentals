package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _01_DragonSharp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Pattern ifPattern = Pattern.compile("if \\((\\d+)(==|<|>)(\\d+)\\)( loop (\\d+))? out \"(.*)\";");
        Pattern elsePattern = Pattern.compile("else( loop (\\d+))? out \"(.*)\";");

        StringBuilder sb = new StringBuilder();
        boolean hasElse = false;

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            Matcher matcherIf = ifPattern
                    .matcher(input);
            Matcher matcherElse = elsePattern
                    .matcher(input);
            boolean ifMatched = matcherIf.matches();
            boolean elseMatched = matcherElse.matches();
            if (!ifMatched && !elseMatched) {
                System.out.printf("Compile time error @ line %d", i + 1);
                return;
            }

            if (ifMatched) {
                hasElse = false;
                int firstNumber = Integer.parseInt(matcherIf.group(1));
                int secondNumber = Integer.parseInt(matcherIf.group(3));
                boolean areEqual = matcherIf.group(2)
                        .equals("==") && firstNumber == secondNumber;
                boolean firstIsSmaller = matcherIf.group(2)
                        .equals("<") && firstNumber < secondNumber;
                boolean firstIsLarger = matcherIf.group(2)
                        .equals(">") && firstNumber > secondNumber;
                if (areEqual || firstIsSmaller || firstIsLarger) {
                    int loops = 1;
                    if (matcherIf.group(4) != null) {
                        loops = Integer.parseInt(matcherIf.group(5));
                    }
                    for (int j = 0; j < loops; j++) {
                        sb.append(matcherIf.group(6) + "\n");
                    }
                }
                else {
                    hasElse = true;
                }
            }
            if (elseMatched && hasElse) {
                int loops = 1;
                if (matcherElse.group(1) != null) {
                    loops = Integer.parseInt(matcherElse.group(2));
                }
                for (int j = 0; j < loops; j++) {
                    sb.append(matcherElse.group(3) + "\n");
                }
            }
        }
        System.out.println(sb);
    }
}
