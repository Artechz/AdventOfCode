package paed.days;

import java.io.File;
import java.util.Scanner;

public class Day2 {

    public static void go() {
        final int X = 0, Y = 1;
        final String PATH = "data/Day2/course.txt";
        File file = new File(PATH);

        int[] location = new int[2];

        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine())
                switch (reader.next())  {
                    case "forward" -> location[X] += reader.nextInt();
                    case "down" -> location[Y] += reader.nextInt();
                    case "up" -> location[Y] -= reader.nextInt();
                }
        }
        catch (Exception ignored){
            System.out.println("Error reading file: " + PATH);
        }

        System.out.println("Final position: (" + location[X] + ", " + location[Y] + ")");
        System.out.println("Result: " + (location[X] * location[Y]));
    }
}
