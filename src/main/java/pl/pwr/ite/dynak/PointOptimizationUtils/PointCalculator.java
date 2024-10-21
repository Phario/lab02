package pl.pwr.ite.dynak.PointOptimizationUtils;

public class PointCalculator {
    //actually does the job of OptionsCalculator (delegation)
    protected double calculate(double radius, int pileAngle, int scoringRule) {
        //this statement returns the amount of points for unit of sand saved
        if (radius == 0 && pileAngle == 0) {
            return scoringRule;
        }
        double height = 2.123;
        //formula for trapezoid height, converts it into points
        double points = height*scoringRule;
        return points;
    }
}
