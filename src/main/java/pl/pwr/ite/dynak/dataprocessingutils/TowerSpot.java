package pl.pwr.ite.dynak.dataprocessingutils;

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
    private boolean buildable = true;
    //HashMap takes the bucket numbers as their keys and the {points,volume,height} as the values
    public TowerSpot(Integer spotNumber, Double radius) {
        this.spotNumber = spotNumber;
        this.radius = radius;
        this.points = new HashMap<>();
        this.height = 0.0;
    }
}
