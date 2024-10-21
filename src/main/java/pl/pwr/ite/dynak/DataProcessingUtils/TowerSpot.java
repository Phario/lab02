package pl.pwr.ite.dynak.DataProcessingUtils;

import java.util.HashMap;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class TowerSpot {
    private Integer spotNumber;
    private Integer radius;
    private HashMap<Integer, Double> points = new HashMap<>();
    private Double totalPoints;
    //HashMap takes the bucket numbers as their keys and the points as the values
    public TowerSpot(Integer spotNumber, Integer radius) {
        this.points = new HashMap<>();
        this.totalPoints = 0.0;
    }
}
