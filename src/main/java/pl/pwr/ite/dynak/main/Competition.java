package pl.pwr.ite.dynak.main;

import pl.pwr.ite.dynak.dataprocessingutils.Bucket;
import pl.pwr.ite.dynak.dataprocessingutils.TowerSpot;
import pl.pwr.ite.dynak.pointoptimizationutils.OptionsCalculator;
import pl.pwr.ite.dynak.towerbuilder.Builder;
import pl.pwr.ite.dynak.towerbuilder.ProcessScribe;

import java.io.IOException;
import java.util.ArrayList;

import static pl.pwr.ite.dynak.dataprocessingutils.ScoringRules.scoringRules;
import static pl.pwr.ite.dynak.dataprocessingutils.TipperLorry.bucketLoader;
import static pl.pwr.ite.dynak.dataprocessingutils.TowerSpotMaker.towerSpotMaker;
import static pl.pwr.ite.dynak.towerbuilder.Jury.calculatePoints;

public class Competition {
    public static void startCompetition() throws IOException {
        //data entry
        double[] scoringRules = scoringRules();
        ArrayList<Bucket> buckets = bucketLoader();
        ArrayList<TowerSpot> towerSpots = towerSpotMaker();
        //instantiating objects
        OptionsCalculator optionsCalculator = new OptionsCalculator();
        Builder builder = new Builder();
        ProcessScribe scribe = new ProcessScribe();
        double height;
        int iterator = 0;

        optionsCalculator.towerSpotPointsCalculator(towerSpots,buckets,scoringRules);
        do {
            iterator++;
            double[] reportData = builder.build(towerSpots, buckets);
            scribe.addData(reportData, iterator);
            optionsCalculator.towerSpotPointsCalculator(towerSpots,buckets,scoringRules); //recalculate points (another missing line)
            height = reportData[1];
        }while (height != 0);

        scribe.saveToFile();
        System.out.println("Your score is: " + calculatePoints(towerSpots,buckets,scoringRules));
    }
}
