package pl.pwr.ite.dynak.Main;

import pl.pwr.ite.dynak.DataProcessingUtils.Bucket;
import pl.pwr.ite.dynak.DataProcessingUtils.TowerSpot;
import pl.pwr.ite.dynak.PointOptimizationUtils.OptionsCalculator;
import pl.pwr.ite.dynak.TowerBuilder.Builder;
import pl.pwr.ite.dynak.TowerBuilder.ProcessScribe;

import java.io.IOException;
import java.util.ArrayList;

import static pl.pwr.ite.dynak.DataProcessingUtils.ScoringRules.scoringRules;
import static pl.pwr.ite.dynak.DataProcessingUtils.TipperLorry.bucketLoader;
import static pl.pwr.ite.dynak.DataProcessingUtils.TowerSpotMaker.towerSpotMaker;
import static pl.pwr.ite.dynak.TowerBuilder.Jury.calculatePoints;

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
            optionsCalculator.towerSpotPointsCalculator(towerSpots,buckets,scoringRules); //recalculate points
            height = reportData[1];
        }while (height != 0);

        scribe.saveToFile();
        System.out.println("Your score is: " + calculatePoints(towerSpots,buckets,scoringRules));
    }
}
