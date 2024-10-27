package pl.pwr.ite.dynak.towerbuilder;

import pl.pwr.ite.dynak.dataprocessingutils.Bucket;
import pl.pwr.ite.dynak.dataprocessingutils.TowerSpot;

import java.util.ArrayList;

//calculates the final points
public class Jury {
    public static double calculatePoints(ArrayList<TowerSpot> towerSpots, ArrayList<Bucket> buckets,double[] scoringRules) {
        double totalPoints;
        double totalHeight = 0.0;
        int spotAmount = 0;
        double savedSand = 0.0;
        for (TowerSpot TowerSpot : towerSpots) {
            spotAmount++;
            totalHeight+=TowerSpot.getHeight();
        }
        for (Bucket Bucket : buckets) {
            savedSand+=Bucket.getContents();
        }
        double avgHeight = totalHeight/spotAmount;
        totalPoints = scoringRules[0]*savedSand + scoringRules[1]*avgHeight;
        return totalPoints;
    }
}
