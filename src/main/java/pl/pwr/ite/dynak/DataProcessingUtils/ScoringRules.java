package pl.pwr.ite.dynak.DataProcessingUtils;

import java.util.Scanner;

public class ScoringRules {
    public static int[] scoringRules() {
        int[] scoringRules = new int[2];
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of points for unit of sand saved: ");
        scoringRules[0] = input.nextInt(); //points for saved sand
        System.out.println("Enter the number of points for unit of tower height: ");
        scoringRules[1] = input.nextInt(); //points for tower height
        input.close();
        return scoringRules;
    }
}