package pl.pwr.ite.dynak.main;

import java.io.IOException;

import static pl.pwr.ite.dynak.main.Competition.startCompetition;

public class Main {
    public static void main(String[] args) throws IOException {
        startCompetition();
        System.out.print("Competition over! Check your score file.");
    }
}