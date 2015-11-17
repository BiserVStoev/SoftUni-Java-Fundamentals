import java.util.Scanner;

public class _03_RubiksMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][cols];
        int[][] secondMatrix = new int[rows][cols];
        int number = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = number;
                secondMatrix[i][j] = number;
                number++;
            }
        }

        for (int i = 0; i < n; i++) {
            String[] commands = scanner.nextLine().split("\\s+");

            int first = Integer.parseInt(commands[0]);
            String direction = commands[1];
            int second = Integer.parseInt(commands[2]);


            if (direction.equals("down") || direction.equals("up")){
                second = second % matrix.length;

            }else if (direction.equals("left") ||direction.equals("right")){
                second = second % matrix[0].length;
            }

            if (direction.equals("down")){
                rollCubeDown(matrix, second, first);

            }else if (direction.equals("up")){
                rollCubeUp(matrix, second, first);

            }else if (direction.equals("left")){
                rollCubeLeft(matrix, second, first);

            }else if (direction.equals("right")) {
                rollCubeRight(matrix, second, first);

            }

        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] != secondMatrix[row][col]){
                    int matrixRow = row;
                    int matrixCol = col;
                    int[] coordinates = findNumberCoordinates(matrix, secondMatrix[row][col]);

                    System.out.printf("Swap (%d, %d) with (%d, %d)\n", row, col, coordinates[0], coordinates[1]);
                    int firstNum = matrix[row][col];
                    int secondNum = matrix[coordinates[0]][coordinates[1]];
                    matrix[row][col] = secondNum;
                    matrix[coordinates[0]][coordinates[1]] = firstNum;

                }else{
                    System.out.println("No swap required");
                }
            }

        }
    }


    static void rollCubeDown(int[][]matrix, int times, int col){

        int[][] clonedMatrix = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < clonedMatrix.length; i++) {
            for (int j = 0; j < clonedMatrix[i].length; j++) {
                clonedMatrix[i][j] = matrix[i][j];
            }
        }

        for (int j = 0; j < times; j++) {
            for (int i = 0; i < matrix.length - 1; i++) {
                matrix[i + 1][col] = clonedMatrix[i][col];
                if (i == 0){
                    matrix[i][col] = clonedMatrix[clonedMatrix.length - 1][col];
                }else{
                    matrix[i][col] = clonedMatrix[i - 1][col];
                }

            }
            copyMatrices(matrix, clonedMatrix);
        }



    }

    static void rollCubeUp(int[][]matrix, int times, int col){
        int[][] clonedMatrix = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < clonedMatrix.length; i++) {
            for (int j = 0; j < clonedMatrix[i].length; j++) {
                clonedMatrix[i][j] = matrix[i][j];
            }
        }

        for (int j = 0; j < times; j++) {
            for (int i = matrix.length - 1; i >= 1; i--) {

                matrix[i - 1][col] = clonedMatrix[i][col];

                if (i == matrix.length - 1){
                    matrix[i][col] = clonedMatrix[0][col];
                }else{
                    matrix[i][col] = clonedMatrix[i + 1][col];
                }

            }
            copyMatrices(matrix, clonedMatrix);
        }

    }

    static void rollCubeRight(int[][]matrix, int times, int row){
        for (int j = 0; j < times; j++) {
            for (int i = matrix[0].length - 1; i >= 1; i--) {
                int holder = matrix[row][i];
                matrix[row][i] = matrix[row ][i - 1];
                matrix[row][i - 1] = holder;
            }
        }

    }

    static void rollCubeLeft(int[][]matrix, int times, int row){
        for (int j = 0; j < times; j++) {
            for (int i = 0; i < matrix[0].length - 1; i++) {
                int holder = matrix[row][i];
                matrix[row][i] = matrix[row][i + 1];
                matrix[row][i + 1] = holder;
            }
        }

    }
    static int[] findNumberCoordinates(int[][] secondMatrix, int number){
        for (int i = 0; i < secondMatrix.length; i++) {
            for (int j = 0; j < secondMatrix[i].length; j++) {
                if (secondMatrix[i][j] == number){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    static void copyMatrices(int[][] firstMatrix, int[][] secondMatrix){

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[i].length; j++) {
                secondMatrix[i][j] = firstMatrix[i][j];
            }
        }
    }

}
