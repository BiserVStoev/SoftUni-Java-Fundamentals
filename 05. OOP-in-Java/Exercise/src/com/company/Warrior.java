package com.company;

import com.company.Exceptions.OutOfEnergyException;

import java.util.IllegalFormatCodePointException;

public class Warrior extends GameCharacter {
    private static final int BASE_HEALTH = 5000;
    private static final int BASE_POWER = 200;
    private static final int BASE_ENERGY = 1000;
    private static final int BASE_ATTACK_COST = 150;

    public Warrior(int health, int power, int energy, int attackCost, String name){
        super(health, power, energy, attackCost, name);
    }

    public Warrior(String name){
        this(BASE_HEALTH, BASE_POWER, BASE_ENERGY, BASE_ATTACK_COST, name);
    }

    @Override
    public void attack(GameCharacter other) throws OutOfEnergyException{
        if (other == this){
            throw new IllegalStateException("Cannot attack itself");
        }

        if (this.getEnergy() < this.getAttackCost()){
            throw new OutOfEnergyException(this.getName() + " is out of energy. Battle over.");
        }

        boolean surgeOfPower = (int) Math.ceil(Math.random()*3) > 2;

        if (surgeOfPower){
            System.out.println(this.getName() + " was lucky. Free attack.");
        }

        this.setEnergy(this.getEnergy() - this.getAttackCost());

        other.respond(this.getPower());
    }

    @Override
    public void respond(int damage){

        int random = (int) Math.ceil(Math.random()*10);

        boolean hasBlocked = random < 7;

        if (hasBlocked){
            System.out.println("Attack was blocked");
            damage = damage / 2;
        }

        this.setHealth(this.getHealth() - damage);
        System.out.println("Successful attack. " + damage + " damage dealt!");
    }
}



