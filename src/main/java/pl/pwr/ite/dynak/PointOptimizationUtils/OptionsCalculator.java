package pl.pwr.ite.dynak.PointOptimizationUtils;

import pl.pwr.ite.dynak.DataProcessingUtils.Bucket;
import pl.pwr.ite.dynak.DataProcessingUtils.TowerSpot;

import java.util.ArrayList;

public class OptionsCalculator {
    /*calculates the points for each individual spot based on available sand,
     points for each goal and sand placing possibilities. Assigns the result to each spot.
     A delegate does the calculations.*/
    private void towerSpotPointsCalculator(ArrayList<TowerSpot> towerSpots, ArrayList<Bucket> buckets, int[] scoringRules) {
        //ArrayList<Float> results = new ArrayList<>();
        PointCalculator pointCalculator = new PointCalculator();

        for (TowerSpot towerSpot : towerSpots) {
            //calculate points for not using any sand (leaving the field empty)
            //0 as the bucket no. indicates, that these are points for not building a tower
            towerSpot.getPoints().put(pointCalculator.calculate(0,0,scoringRules[0]), 0);
            for (Bucket bucket : buckets) {
                //calculate the points per bucket if it isn't empty
                if (bucket.getContents() != 0) {
                    towerSpot.getPoints().put(pointCalculator.calculate(towerSpot.getRadius(), bucket.getPileAngle(), scoringRules[1]), bucket.getBucketNo());
                }
            }
        }

    }
}
