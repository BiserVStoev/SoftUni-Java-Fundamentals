package com.company;

import com.company.Exceptions.OutOfEnergyException;

public class Mage extends GameCharacter {
    private static final int BASE_HEALTH = 5000;
    private static final int BASE_POWER = 150;
    private static final int BASE_ENERGY = 2500;
    private static final int BASE_ATTACK_COST = 250;

    private static final double CRITICAL_HIT_THRESHOLD = 0.5;

    public Mage(int health, int power, int energy, int attackCost, String name){
        super(health, power, energy, attackCost, name);
    }

    public Mage(String name){
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

        boolean isCritical = Math.random() < CRITICAL_HIT_THRESHOLD;

        int damage = this.getPower();
        if (isCritical){
            System.out.println("Critical hit by the mage!");
        }

        this.setEnergy(this.getEnergy() - this.getAttackCost());

        other.respond(damage);
    }

    @Override
    public void respond(int damage){

        int random = (int) Math.ceil(Math.random()*2);

        boolean hasTeleported = random > 1;

        if (hasTeleported){
            System.out.println("The mage teleported and evaded the attack");
        }else{
            this.setHealth(this.getHealth() - damage);
            System.out.println("Successful attack. " + damage + " damage dealt!");
        }
    }
}


