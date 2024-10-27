package pl.pwr.ite.dynak.pointoptimizationutils;
import static java.lang.Math.*;
import static pl.pwr.ite.dynak.dataprocessingutils.RadiusCalculator.calculateNewRadius;

public class PointCalculator {
    /*actually does the job of OptionsCalculator (delegation)
    if the radius, pileAngle and sandLeft is 0, the method returns the amount of
    points equal to saving the sand in this turn(not building anymore on this spot).
    Returns the amount of points and volume of sand needed to build each trapezoid/triangle*/
    protected Double[] calculate(double radius, int pileAngle, double scoringRule, double sandLeft) {
        double height = 0;
        double radAngle = Math.toRadians(pileAngle);
        //check if trapezoid can be built:
        double coneVolume = (1.0/3.0)*3.14*pow(radius, 3)*tan(radAngle);
        double coneHeight = 3/(3.14*pow(radius, 2));
        boolean canBuildFullTrapezoid = (coneVolume >= 1);
        if (canBuildFullTrapezoid) {
            //this statement returns the amount of points for unit of sand saved
            if (radius == 0 && radAngle == 0 && sandLeft == 0) {
                return new Double[]{scoringRule, 0.0, height};
            }
            //calculate height and set volume to 1 for normal trapezoid
            else if (radius != 0 && radAngle != 0 && sandLeft >= 1) {
                height = tan(radAngle) * (radius - calculateNewRadius(radAngle, radius, 1));
                return new Double[]{height*scoringRule, 1.0, height}; //missing line ffs
            }
        }
        else {
            //calculate points for not building the cone
            if (radius == 0 && radAngle == 0 && sandLeft == 0) {
                return new Double[]{scoringRule,0.0, height};
            }
            //check if there is enough sand to build a cone:
            else if (sandLeft >= coneVolume) {
                height = coneHeight;
                return new Double[]{-height*scoringRule, coneVolume, height};
            }
            //or return 0 if you can't
            else return new Double[]{0.0,0.0};
        }
        return new Double[]{height*scoringRule, 0.0, height};
    }
}
