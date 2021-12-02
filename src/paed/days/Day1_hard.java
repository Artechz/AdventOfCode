package paed.days;

import java.util.ArrayList;

public class Day1_hard {
    public static void go() {
        ArrayList<Integer> sonar_data = Day1.readSonarData("data/Day1/sonar.txt");

        int[] range = new int[3];
        int total = 0, prev = 0;

        for (Integer s : sonar_data) {
            range[2] = range[1];
            range[1] = range[0];
            range[0] = s;

            System.out.println("(" + range[2] + ", " + range[1] + ", " + range[0] + ") = " + sumOfRange(range) + " ?> " + prev + " => " + (sumOfRange(range) > prev));

            if (sumOfRange(range) > prev) total++;
            prev = sumOfRange(range);
        }

        System.out.println("Increments: " + (total-3));
    }

    private static int sumOfRange(int[] range) {
        int total = 0;
        for (Integer i : range) {
            total += i;
        }
        return total;
    }
}
