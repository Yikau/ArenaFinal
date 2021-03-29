package cz.educanet.arena.logic;

import java.util.Random;

public class Gladiator {

    private String name;
    private int maxHealth;
    private int hp;
    private int minDmg;
    private int maxDmg;
    private int dmg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp){
        this.hp = hp;
    }

    public int getMaxDmg() {
        return maxDmg;
    }

    public void setMaxDmg(int maxDmg) {
        this.maxDmg = maxDmg;
    }

    public int getMinDmg() {
        return minDmg;
    }

    public void setMinDmg(int minDmg) {
        this.minDmg = minDmg;
    }

    public boolean isDead() {

        return (hp <= 0);
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void dealDamage(Gladiator enemy) {
        Random deal = new Random();
        int Ddmg = (deal.nextInt((int) (Math.random() * (maxDmg - minDmg) + minDmg)));
        setDmg(Ddmg);
        enemy.setHp(enemy.getHp() - Ddmg);
    }
}
