package pl.pwr.ite.dynak.TowerBuilder;

import pl.pwr.ite.dynak.DataProcessingUtils.Bucket;
import pl.pwr.ite.dynak.DataProcessingUtils.TowerSpot;

import java.util.ArrayList;
import java.util.Set;

//makes decisions and builds towers
public class Builder {
    //decides on the tower spot to build (or stop building)
    public int[] chooseSpotAndBucket(ArrayList<TowerSpot> towerSpots, ArrayList<Bucket> buckets) {
        double points = 0;
        int bucketNumber = 0;
        int spotNumber = 0;
        for (TowerSpot towerSpot : towerSpots) {
            //check points for not building any trapezoids
            if (points <= towerSpot.getPoints().get(0)) {
                points = towerSpot.getPoints().get(0);
                spotNumber = towerSpot.getSpotNumber();
                bucketNumber = 0;
            }
            for (Bucket bucket : buckets) {
                if (points < towerSpot.getPoints().get(bucket.getBucketNo())) {
                    points = towerSpot.getPoints().get(bucket.getBucketNo());
                    bucketNumber = bucket.getBucketNo();
                    spotNumber = towerSpot.getSpotNumber();
                }
            }
        }
        return new int[]{spotNumber, bucketNumber};
    }
    //TODO: add scribe process, add updater, check the above for errors, pray to god I haven't fucked up the logic
}
