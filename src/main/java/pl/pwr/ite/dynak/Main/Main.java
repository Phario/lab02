package pl.pwr.ite.dynak.Main;

import pl.pwr.ite.dynak.DataProcessingUtils.Bucket;
import pl.pwr.ite.dynak.DataProcessingUtils.TowerSpot;

import java.io.IOException;
import java.util.ArrayList;
import static pl.pwr.ite.dynak.DataProcessingUtils.TipperLorry.*;
import static pl.pwr.ite.dynak.DataProcessingUtils.TowerSpotMaker.*;
public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Bucket> Buckets = bucketLoader();
        for (Bucket Bucket : Buckets) {
            System.out.println(Bucket.getBucketNo() + " " + Bucket.getContents() + " " + Bucket.getPileAngle());
        }
        ArrayList<TowerSpot> towerSpotArrayList = towerSpotMaker();
        for (TowerSpot TowerSpot : towerSpotArrayList) {
            System.out.println(TowerSpot.spotNumber() + " " + TowerSpot.radius());
        }
    }
}