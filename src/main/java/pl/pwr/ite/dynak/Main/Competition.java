package pl.pwr.ite.dynak.Main;

import pl.pwr.ite.dynak.DataProcessingUtils.Bucket;
import pl.pwr.ite.dynak.DataProcessingUtils.TowerSpot;
import pl.pwr.ite.dynak.PointOptimizationUtils.OptionsCalculator;
import pl.pwr.ite.dynak.TowerBuilder.Builder;

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
        //
        OptionsCalculator optionsCalculator = new OptionsCalculator();
        optionsCalculator.towerSpotPointsCalculator(towerSpots,buckets,scoringRules);
        Builder builder = new Builder();
        while (builder.build(towerSpots,buckets)[1] != 0) {
            optionsCalculator.towerSpotPointsCalculator(towerSpots,buckets,scoringRules);
        }
        System.out.println("Your score is: " + calculatePoints(towerSpots,buckets,scoringRules));
    }
}
