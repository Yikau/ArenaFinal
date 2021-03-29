package cz.educanet.arena.logic;

public class Arena {

    private Gladiator gladiator1;
    private Gladiator gladiator2;

    private int round;


    public void fight() {
        System.out.println("---------------- Round " + (round + 1) + " ----------------");
        System.out.println("Fight " + gladiator1.getName() + " VS " + gladiator2.getName());
        System.out.println("-----------------------------------------");
        System.out.println(gladiator1.getName() + " has " + gladiator1.getHp() + " HP");
        System.out.println("-----------------------------------------");
        System.out.println(gladiator2.getName() + " has " + gladiator2.getHp() + " HP");
        System.out.println("-----------------------------------------");
        gladiator1.dealDamage(gladiator2);
        System.out.println(gladiator1.getName() + " dealt " + gladiator1.getDmg() + " damage to his opponent!");
        System.out.println("-----------------------------------------");
        gladiator2.dealDamage(gladiator1);
        System.out.println(gladiator2.getName() + " dealt " + gladiator2.getDmg() + " damage to his opponent!");
        System.out.println("-----------------------------------------");
        round++;
    }

    public Gladiator getWinner() {
        if (gladiator1.isDead()) return gladiator2;
        if (gladiator2.isDead()) return gladiator1;

            return null;
    }

    public void setGladiator1(Gladiator gladiator1) {
        this.gladiator1 = gladiator1;
    }
    public void setGladiator2(Gladiator gladiator2) {
        this.gladiator2 = gladiator2;
    }
}
