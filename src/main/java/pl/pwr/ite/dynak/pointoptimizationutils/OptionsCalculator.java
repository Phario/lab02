package pl.pwr.ite.dynak.pointoptimizationutils;

import pl.pwr.ite.dynak.dataprocessingutils.Bucket;
import pl.pwr.ite.dynak.dataprocessingutils.TowerSpot;

import java.util.ArrayList;

public class OptionsCalculator {
    /*calculates the points for each individual spot based on available sand,
    points for each goal and sand placing possibilities. Assigns the result to each spot.
    A delegate does the calculations.

    If this method returns a negative value, it indicates that a trapezoid cannot be built,
    instead, a cone can be built with an amount of points equal to the absolute value of the returned number*/
    public void towerSpotPointsCalculator(ArrayList<TowerSpot> towerSpots, ArrayList<Bucket> buckets, double[] scoringRules) {
        //ArrayList<Float> results = new ArrayList<>();
        PointCalculator pointCalculator = new PointCalculator();

        for (TowerSpot towerSpot : towerSpots) {
            //calculate points for not using any sand (leaving the field empty)
            //0 as the bucket no. indicates, that these are points for not building a tower
            towerSpot.getPoints().put(0 ,pointCalculator.calculate(0,0,scoringRules[0], 0));

            for (Bucket bucket : buckets) {
                //calculate the points per bucket if it isn't empty
                if (bucket.getContents() != 0) {
                    towerSpot.getPoints().put(bucket.getBucketNo(), pointCalculator.calculate(towerSpot.getRadius(), bucket.getPileAngle(), scoringRules[1], bucket.getContents()));
                }
                //set points per bucket to 0 if a bucket is empty:
                else if (bucket.getContents() == 0) {
                    Double[] empty = {0.0,0.0};
                    towerSpot.getPoints().put(bucket.getBucketNo(), empty);
                }
            }
        }
    }
}
