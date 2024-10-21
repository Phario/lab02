package pl.pwr.ite.dynak.DataProcessingUtils;

import java.util.HashMap;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class TowerSpot {
    private Integer spotNumber;
    private Integer radius;
    private HashMap<Double, Integer> points = new HashMap<>();
    private Double totalPoints;
    //HashMap takes the points as the key and the bucket numbers as their values
    public TowerSpot(Integer spotNumber, Integer radius) {
        this.points = new HashMap<>();
        this.totalPoints = 0.0;
    }
}
