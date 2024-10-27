package pl.pwr.ite.dynak.dataprocessingutils;

import java.util.Scanner;

public class ScoringRules {
    public static double[] scoringRules() {
        double[] scoringRules = new double[2];
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of points for unit of sand saved: ");
        scoringRules[0] = input.nextInt(); //points for saved sand
        System.out.println("Enter the number of points for unit of tower height: ");
        scoringRules[1] = input.nextInt(); //points for tower height
        //input.close();
        return scoringRules;
    }
}
