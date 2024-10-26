package pl.pwr.ite.dynak.DataProcessingUtils;

import java.util.HashMap;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class TowerSpot {
    private Integer spotNumber;
    private Double radius;
    private HashMap<Integer, Double[]> points;
    private double height;
    private boolean buildable;
    //HashMap takes the bucket numbers as their keys and the {points,volume} as the values
    public TowerSpot(Integer spotNumber, Double radius) {
        this.spotNumber = spotNumber;
        this.radius = radius;
        this.points = new HashMap<>();
        this.height = 0.0;
        if (radius > 0) {
            this.buildable = true;
        }
    }
}
