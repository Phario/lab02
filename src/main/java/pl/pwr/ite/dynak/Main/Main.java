package pl.pwr.ite.dynak.Main;

import pl.pwr.ite.dynak.DataProcessingUtils.Bucket;
import pl.pwr.ite.dynak.DataProcessingUtils.TowerSpot;

import java.io.IOException;
import java.util.ArrayList;
import static pl.pwr.ite.dynak.DataProcessingUtils.TipperLorry.*;
import static pl.pwr.ite.dynak.DataProcessingUtils.TowerSpotMaker.*;
import static pl.pwr.ite.dynak.Main.Competition.startCompetition;

public class Main {
    public static void main(String[] args) throws IOException {
        startCompetition();
        System.out.print("Competition over! Check your score file.");
    }
}