import java.util.Scanner;

public class _01_SoftUniPalatkaConf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        int numberOfLines = Integer.parseInt(scanner.nextLine());

        int food = 0;
        int beds = 0;

        for (int i = 0; i < numberOfLines; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String firstType = input[0];
            int quantity = Integer.parseInt(input[1]);
            String type = input[2];

            if (firstType.equals("tents")){
                if (type.equals("normal")){
                    beds += quantity * 2;
                }else if (type.equals("firstClass")){
                    beds += quantity * 3;
                }

            }else if (firstType.equals("rooms")){
                if (type.equals("single")){
                    beds += quantity;
                }else if (type.equals("double")){
                    beds += quantity * 2;

                }else if (type.equals("triple")){
                    beds += quantity * 3;
                }

            }else if (firstType.equals("food")){
                if (type.equals("musaka")){
                    food += quantity * 2;
                }else if (type.equals("zakuska")){
                    food += quantity * 0;
                }
            }
        }

        if (beds >= numberOfPeople){
            System.out.printf("Everyone is happy and sleeping well. Beds left: %d\n", beds - numberOfPeople);
        }else {
            System.out.printf("Some people are freezing cold. Beds needed: %d\n", numberOfPeople - beds);
        }

        if (food >= numberOfPeople){
            System.out.printf("Nobody left hungry. Meals left: %d\n", food - numberOfPeople);
        }else {
            System.out.printf("People are starving. Meals needed: %d\n", numberOfPeople - food);
        }
    }
}
