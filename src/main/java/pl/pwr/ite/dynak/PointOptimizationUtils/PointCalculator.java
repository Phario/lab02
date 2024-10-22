package pl.pwr.ite.dynak.PointOptimizationUtils;
import static java.lang.Math.*;
import static pl.pwr.ite.dynak.DataProcessingUtils.RadiusCalculator.calculateNewRadius;

public class PointCalculator {
    /*actually does the job of OptionsCalculator (delegation)
    if the radius, pileAngle and sandLeft is 0, the method returns the amount of
    points equal to saving the sand in this turn(not building anymore on this spot)*/
    protected double calculate(double radius, int pileAngle, int scoringRule, double sandLeft) {
        double height = 0;
        //check if trapezoid can be built:
        double coneFullUnitVolume = (1.0/3.0)*3.14*pow(radius, 3)*tan(pileAngle);
        double coneFullUnitHeight = 3/(3.14*pow(radius, 2));
        boolean canBuildFullTrapezoid = (coneFullUnitVolume >= 1);
        if (canBuildFullTrapezoid) {
            //this statement returns the amount of points for unit of sand saved
            if (radius == 0 && pileAngle == 0 && sandLeft == 0) {
                return scoringRule;
            }
            //calculate height for normal trapezoid
            else if (radius != 0 && pileAngle != 0 && sandLeft >= 1) {
                height = tan(pileAngle) * (radius - calculateNewRadius(pileAngle, radius, 1));
            }
        }
        //TODO: Fix logic for cone building if trapezoid cannot be built
        else {
            //check if you can build a full cone
            //check if there is enough sand to build a full cone:
            if (sandLeft >= 1) {
                height = (3*(1/3.14))/pow(radius, 2);
                return -height*scoringRule;
            }
            //return points for not fully built trapezoid (ie built with leftovers)
            else if (sandLeft < 1) {
                height = tan(pileAngle) * (radius - calculateNewRadius(pileAngle, radius, sandLeft));
                if (height < coneFullUnitHeight) {}
            }
            //check how many points for a cone built with leftovers
            else {
                height = (3*sandLeft)/(3.14*pow(radius, 2));
                return -height*scoringRule;
            }
        }
        double points = height*scoringRule;
        return points;

    }
}
