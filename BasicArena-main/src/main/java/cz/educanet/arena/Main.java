package cz.educanet.arena;

import cz.educanet.arena.presentation.ArenaCLI;

public class Main {

    public static void main(String[] args) {
        ArenaCLI cli = new ArenaCLI();
        cli.init();
        cli.renderLandingPage();
        cli.CaPChoice();
        cli.renderEntireFight();

    }

}
