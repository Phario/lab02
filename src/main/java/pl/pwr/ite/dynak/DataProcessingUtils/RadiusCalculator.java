package pl.pwr.ite.dynak.DataProcessingUtils;
import static java.lang.Math.*;
public class RadiusCalculator {
    public static double calculateNewRadius(int angle, double radius, double volume) {
        return cbrt(pow(radius, 3) - 3*volume/(tan(angle)*3.14));
    }
}
