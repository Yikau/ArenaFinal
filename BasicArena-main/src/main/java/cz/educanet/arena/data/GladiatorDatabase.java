package cz.educanet.arena.data;

import cz.educanet.arena.logic.Gladiator;

import java.io.*;
public class GladiatorDatabase {

    public static Gladiator loadGladiator(String filename) {
        Gladiator newGladiator = new Gladiator();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("bojovnici/" + filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            assert br != null;
            newGladiator.setName(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            newGladiator.setMaxHealth(Integer.parseInt(br.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            newGladiator.setMaxDmg(Integer.parseInt(br.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            newGladiator.setMinDmg(Integer.parseInt(br.readLine()));
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return newGladiator;
    }

    public static void saveGladiator(String filename, Gladiator gladiator) {
        try {
            BufferedWriter Bwriter = new BufferedWriter(new FileWriter("bojovnici/" + filename));

            Bwriter.write(gladiator.getName()+"");
            Bwriter.newLine();
            Bwriter.write(gladiator.getMaxHealth()+"");
            Bwriter.newLine();
            Bwriter.write(gladiator.getMinDmg()+"");
            Bwriter.newLine();
            Bwriter.write(gladiator.getMaxDmg()+"");
            Bwriter.newLine();

            Bwriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


