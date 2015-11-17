package com.company;

import com.company.Exceptions.OutOfEnergyException;

public class Battle {

    public static void main(String[] args)throws InterruptedException {
        GameCharacter goshoTheWarrior = new Warrior("Gosho");
        GameCharacter peshoTheMage = new Mage("Pesho");

        int roundCount = 0;

        while (true){
            System.out.println("Round: " + ++roundCount);
            try {
                if (roundCount % 2 == 0){
                    goshoTheWarrior.attack(peshoTheMage);
                    peshoTheMage.attack(goshoTheWarrior);
                }else{
                    peshoTheMage.attack(goshoTheWarrior);
                    goshoTheWarrior.attack(peshoTheMage);
                }

            }catch (OutOfEnergyException e){
                System.out.println(e.getMessage());

                break;
            }

            Thread.sleep(2000);
            System.out.println();
        }

        System.out.println("Winner: " + (goshoTheWarrior.getHealth() < peshoTheMage.getHealth() ? peshoTheMage.getName() : goshoTheWarrior));
    }
}
