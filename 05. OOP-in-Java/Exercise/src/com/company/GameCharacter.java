package com.company;

import com.company.Exceptions.OutOfEnergyException;

public abstract class GameCharacter {

    private int health;
    private int power;
    private int energy;
    private int attackCost;
    private String name;

    public GameCharacter(int health, int power, int energy, int attackCost, String name){
        this.health = health;
        this.power = power;
        this.energy = energy;
        this.attackCost = attackCost;
        this.name = name;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public int getPower(){
        return this.power;
    }

    public void setPower(int power){
        this.power = power;
    }

    public int getEnergy(){
        return this.energy;
    }

    public void setEnergy(int energy){
        this.energy = energy;
    }

    public int getAttackCost(){
        return this.attackCost;
    }

    public void setAttackCost(int attackCost){
        this.attackCost = attackCost;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public abstract void attack (GameCharacter other) throws OutOfEnergyException;

    public abstract void respond (int damage);
}
