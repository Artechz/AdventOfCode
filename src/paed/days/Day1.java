package paed.days;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
    public static void go() {

        ArrayList<Integer> sonar_data = readSonarData("data/Day1/sonar.txt");

        int prev = 0, total = 0;
        for (Integer s : sonar_data) {
            if (s > prev) total++;
            System.out.println(s);
            prev = s;
        }

        System.out.println("Increments: " + (total-1));
    }

    public static ArrayList<Integer> readSonarData(final String PATH) {

        File file = new File(PATH);
        ArrayList<Integer> result = new ArrayList<>();

        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine())
                result.add(reader.nextInt());
        }
        catch (Exception ignored){
            System.out.println("Error reading file: " + PATH);
        }

        return result;
    }

}
