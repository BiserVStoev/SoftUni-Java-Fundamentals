package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class _02_Durts {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] coordinates = scanner.nextLine().split(" ");

        int cX = Integer.parseInt(coordinates[0]);
        int cY = Integer.parseInt(coordinates[1]);

        int r = Integer.parseInt(scanner.nextLine());
        int count = Integer.parseInt(scanner.nextLine());

        Integer[] allNums = new Integer[count * 2];

        for (int i = 0; i < allNums.length; i++) {
            allNums[i] = scanner.nextInt();
        }


        double verticalMinX = cX - (r / 2.0);
        double verticalMaxX = cX + (r / 2.0);
        double verticalMinY = cY - r;
        double verticalMaxY = cY + r;

        double horizontalMinX = cX - r;
        double horizontalMaxX = cX + r;
        double horizontalMinY = cY - (r / 2.0);
        double horizontalMaxY = cY + (r / 2.0);


        for (int i = 0; i < allNums.length; i+=2) {
            System.out.println(checkIfHit(allNums[i], allNums[i + 1],
                    horizontalMaxX, horizontalMinX, horizontalMaxY, horizontalMinY,
                    verticalMaxX, verticalMinX, verticalMaxY, verticalMinY));
        }
    }

    public static String checkIfHit(int x, int y,
                                    double maxXH, double minXH, double maxYH, double minYH,
                                    double maxXV, double minXV, double maxYV, double minYV) {

        String toRetun = "";
        if ((x <= maxXH) && (x >= minXH) && (y <= maxYH) && (y >= minYH) ||
                (x <= maxXV && x >= minXV) && (y <= maxYV) && (y >= minYV)){

            toRetun = "yes";
        }else{
            toRetun = "no";
        }

        return toRetun;
    }
}