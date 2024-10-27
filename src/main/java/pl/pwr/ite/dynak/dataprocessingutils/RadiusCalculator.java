package pl.pwr.ite.dynak.dataprocessingutils;
import static java.lang.Math.*;
public class RadiusCalculator {
    public static double calculateNewRadius(double angle, double radius, double volume) {
        double radAngle = angle*3.14/180;
        return cbrt(pow(radius, 3) - 3*volume/(tan(radAngle)*3.14));
    }
}
