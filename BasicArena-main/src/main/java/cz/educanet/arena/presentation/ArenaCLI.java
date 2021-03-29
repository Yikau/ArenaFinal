package cz.educanet.arena.presentation;

import cz.educanet.arena.data.GladiatorDatabase;
import cz.educanet.arena.logic.Arena;
import cz.educanet.arena.logic.Gladiator;

import java.util.Scanner;

public class ArenaCLI {

    private Arena logic;
    private Scanner sc;

    public void init() {
        logic = new Arena();
        sc = new Scanner(System.in);
    }

    public void renderLandingPage() {
        System.out.println("  ___  ______ _____ _   _   ___  \n" +
                " / _ \\ | ___ \\  ___| \\ | | / _ \\ \n" +
                "/ /_\\ \\| |_/ / |__ |  \\| |/ /_\\ \\\n" +
                "|  _  ||    /|  __|| . ` ||  _  |\n" +
                "| | | || |\\ \\| |___| |\\  || | | |\n" +
                "\\_| |_/\\_| \\_\\____/\\_| \\_/\\_| |_/\n");
        System.out.println("-----------------------------------------");
    }

    public void CaPChoice(){
        System.out.println("Do you want to create or choose a gladiator.(Yes/No");
        String YN = sc.nextLine();
        YN = YN.toLowerCase();
        if (YN.equals("yes") || YN.equals("ye") || YN.equals("y")){
            GladiatorNew();
        }
        else{
            renderGladiatorPicker();
        }
    }

    public void renderGladiatorPicker() {
        System.out.println("Choose a gladiator from /bojovnici");
        System.out.println("-----------------------------------------");
        String gladiator1File = sc.nextLine().toLowerCase();
        System.out.println("Choose second gladiator from /bojovnici");
        System.out.println("-----------------------------------------");
        String gladiator2File = sc.nextLine().toLowerCase();



        Gladiator gladiator1 = GladiatorDatabase.loadGladiator(gladiator1File);
        Gladiator gladiator2 = GladiatorDatabase.loadGladiator(gladiator2File);
        logic.setGladiator1(gladiator1);
        logic.setGladiator2(gladiator2);
    }

    public void GladiatorNew(){
        Gladiator gladiator1 = new Gladiator();
        Gladiator gladiator2 = new Gladiator();

        System.out.println("-----------------------------------------");
        System.out.println("Choose a name for the first gladiator: ");
        System.out.println("-----------------------------------------");
        gladiator1.setName(sc.nextLine());
        System.out.println("-----------------------------------------");
        System.out.println("Choose a number of HP(Health Points) for the first gladiator(In numbers/integers.): ");
        System.out.println("-----------------------------------------");
        gladiator1.setHp(Integer.parseInt(sc.nextLine()));
        System.out.println("-----------------------------------------");
        System.out.println("Set first gladiator's minimal damage(we recommend you to not choose an extremely huge damage, as it may hinder the game experience and type in numbers/integers.): ");
        System.out.println("-----------------------------------------");
        gladiator1.setMinDmg(Integer.parseInt(sc.nextLine()));
        System.out.println("-----------------------------------------");
        System.out.println("Now choose gladiator's maximal damage(we recommend you to not choose an extremely huge damage, as it may hinder the game experience and type in numbers/integers.): ");
        System.out.println("-----------------------------------------");
        gladiator1.setMaxDmg(Integer.parseInt(sc.nextLine()));

        System.out.println("-----------------------------------------");
        System.out.println("Now is the time for the second fighter!");
        System.out.println("-----------------------------------------");
        System.out.println("Firstly, choose his/hers name: ");
        System.out.println("-----------------------------------------");
        gladiator2.setName(sc.nextLine());
        System.out.println("-----------------------------------------");
        System.out.println("Choose a number of HP(Health Points) for him/her(In numbers/integers.): ");
        System.out.println("-----------------------------------------");
        gladiator2.setHp(Integer.parseInt(sc.nextLine()));
        System.out.println("-----------------------------------------");
        System.out.println("Set his/hers gladiator's minimal damage(we recommend you to not choose an extremely huge damage, as it may hinder the game experience and type in numbers/integers.): ");
        System.out.println("-----------------------------------------");
        gladiator2.setMinDmg(Integer.parseInt(sc.nextLine()));
        System.out.println("-----------------------------------------");
        System.out.println("Now set his/hers maximal damage(we recommend you to not choose an extremely huge damage, as it may hinder the game experience and type in numbers/integers.): ");
        System.out.println("-----------------------------------------");
        gladiator2.setMaxDmg(Integer.parseInt(sc.nextLine()));
        System.out.println("-----------------------------------------");
        System.out.println("You have created 2 new gladiators: " + gladiator1.getName() + " and " + gladiator2.getName() + "." );

        GladiatorDatabase.saveGladiator(gladiator1.getName() + ".txt", gladiator1);
        GladiatorDatabase.saveGladiator(gladiator2.getName() + ".txt", gladiator2);
        logic.setGladiator1(gladiator1);
        logic.setGladiator2(gladiator2);

    }

    public void renderEntireFight() {
        while (logic.getWinner() == null){
            logic.fight();
        }
        System.out.println(logic.getWinner().getName() + " has won the fight!");
        System.out.println("-----------------------------------------");

    }

}
