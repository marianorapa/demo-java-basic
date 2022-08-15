package com.example.demo.model;

import java.util.List;

public class Guerrero {

    private String name;

    private int attackPower;

    private List<Guerrero> brothers;

    public Guerrero(String name, int attackPower) {
        this.name = name;
        this.attackPower = attackPower;

    }

    public String getName() {
        return name;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void addBrother(Guerrero brother) {
        this.brothers.add(brother);
    }
}
