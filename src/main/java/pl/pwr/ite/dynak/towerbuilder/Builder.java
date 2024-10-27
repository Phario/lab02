package pl.pwr.ite.dynak.towerbuilder;

import pl.pwr.ite.dynak.dataprocessingutils.Bucket;
import pl.pwr.ite.dynak.dataprocessingutils.TowerSpot;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;

import static java.lang.Math.abs;
import static pl.pwr.ite.dynak.dataprocessingutils.RadiusCalculator.calculateNewRadius;

//makes decisions and builds towers
@Getter
@Setter
public class Builder {
    public Builder() {
    }
    public double[] build(ArrayList<TowerSpot> towerSpots, ArrayList <Bucket> buckets) {
        double[] decision = chooseSpotAndBucket(towerSpots, buckets);
        int spotNumber = (int) decision[0];
        int bucketNumber = (int) decision[1];
        double volume = decision[2]; //volume of sand used to build a segment
        //reportData is new radius, height, volume of sand used, spotNumber and bucketNumber
        double[] reportData = new double[5];
        reportData[2] = volume;
        reportData[3] = spotNumber;
        reportData[4] = bucketNumber;
        if (bucketNumber != 0) {
            for (TowerSpot towerSpot : towerSpots) {
                if (towerSpot.getSpotNumber() == spotNumber && towerSpot.isBuildable()) {
                    for (Bucket bucket : buckets) {
                        if (bucket.getBucketNo() == bucketNumber) {
                            //build trapezoid
                            if (towerSpot.getPoints().get(bucketNumber)[0] > 0) {
                                int pileAngle = bucket.getPileAngle();
                                double spotRadius = towerSpot.getRadius();
                                //give new radius to a spot
                                double newRadius = calculateNewRadius(pileAngle, spotRadius, volume);
                                towerSpot.setRadius(newRadius);
                                //give new height to a spot
                                double newHeight = towerSpot.getHeight() + towerSpot.getPoints().get(bucketNumber)[2];
                                towerSpot.setHeight(newHeight);
                                reportData[0] = newRadius;
                                reportData[1] = newHeight;
                            }
                            //build cone
                            else if (towerSpot.getPoints().get(bucketNumber)[0] < 0){
                                //give new radius to a spot
                                double newRadius = 0;
                                //give new height to a spot
                                double newHeight = towerSpot.getHeight() + towerSpot.getPoints().get(bucketNumber)[2];
                                towerSpot.setBuildable(false);
                                reportData[0] = newRadius;
                                reportData[1] = newHeight;
                            }
                            //if reportData[1] (height) is 0, stop the building process
                            //because either every bucket is empty or you can't build any higher
                            else reportData[1] = 0.0;
                            bucket.setContents(bucket.getContents()-volume);
                        }
                    }
                }
            }
        }
        return reportData;
    }
    //finds the best amount of points and decides on the tower spot to build (or stop building)
    private static double[] chooseSpotAndBucket(ArrayList<TowerSpot> towerSpots, ArrayList<Bucket> buckets) {
        double points = 0;
        double bucketNumber = 0;
        double spotNumber = 0;
        double volume = 0.0;
        for (TowerSpot towerSpot : towerSpots) {
            //check points for not building any trapezoids
            if (points <= towerSpot.getPoints().get(0)[0]) {
                points = towerSpot.getPoints().get(0)[0];
                volume = 0.0;
                spotNumber = towerSpot.getSpotNumber();
                bucketNumber = 0;
            }
            for (Bucket bucket : buckets) {
                if (points < abs(towerSpot.getPoints().get(bucket.getBucketNo())[0])) {
                    points = towerSpot.getPoints().get(bucket.getBucketNo())[0];
                    volume = towerSpot.getPoints().get(bucket.getBucketNo())[1];
                    bucketNumber = bucket.getBucketNo();
                    spotNumber = towerSpot.getSpotNumber();
                }
            }
        }
        System.out.println(spotNumber + " " + bucketNumber + " " + volume);
        return new double[]{spotNumber, bucketNumber, volume};
    }
}