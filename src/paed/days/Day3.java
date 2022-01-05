package paed.days;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day3 {

    public static void go() {
        final String PATH = "data/Day3/diagnostic_test.txt";
        File file = new File(PATH);

        ArrayList<Long> diagnostics = new ArrayList<>();
        ArrayList<Long> oxygenList = new ArrayList<>();
        ArrayList<Long> co2List = new ArrayList<>();

        for (Long i : diagnostics) {
          oxygenList.add(i);
          co2List.add(i);
        }

        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine())
                diagnostics.add(reader.nextLong());
        } catch (Exception ignored) {
            System.out.println("Error reading file: " + PATH);
        }

        final int DIAG_SIZE = 5;
        int[] gamma = new int[DIAG_SIZE];
        int[] epsilon = new int[DIAG_SIZE];
        for (int j = 0; j < DIAG_SIZE; j++) {

            int counter = 0;
            for (Long i : diagnostics) {
                counter +=
                        (i / (long)Math.pow(10, j)) % (10);
                System.out.println((i / (long)Math.pow(10, j)) % (10));
            }
            if (counter > diagnostics.size() / 2) gamma[DIAG_SIZE-1-j] = 1;
            else epsilon[DIAG_SIZE-1-j] = 1;
            System.out.println(gamma[DIAG_SIZE-1-j] + "-" + epsilon[DIAG_SIZE-1-j]);

            for (Long i : diagnostics) {
                if (gamma[j] == (i / (long)Math.pow(10, j)) % (10))
                    co2List.remove(i);
                else oxygenList.remove(i);

                //diagnostics.remove
            }
        }
        System.out.println(Arrays.toString(gamma) + "-"  + Arrays.toString(epsilon));
        long gamma_ = Long.parseLong(arrayToString(gamma),2);
        long epsilon_ = Long.parseLong(arrayToString(epsilon),2);
        System.out.println(gamma_ + "*" + epsilon_ + "=" + (gamma_ * epsilon_));
    }

    private static long arrayToInt(int[] ar) {
        long res = 0;
        for(int i=0,exp=ar.length-1;i<ar.length;i++,exp--)
            res+=ar[i]*Math.pow(10, exp);
        return res;
    }

    private static String arrayToString(int[] ar) {
        StringBuilder s = new StringBuilder();

        for (int i : ar)
            s.append(i); //add all the ints to a string
        return s.toString();
    }
}
