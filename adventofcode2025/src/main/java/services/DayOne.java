package services;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class DayOne {
    public static final int STARTING_POINT = 50;
    public static final int BEGIN = 0;
    public static final int END = 99;

    public void findPassword(Path input) throws IOException {
        var rotations = extractRotations(input);

        var password = 0;
        int currentPosition = STARTING_POINT;

        for (var rotation : rotations) {
            IO.println("Old position: " + currentPosition);

            switch(rotation.direction()) {
                case 'R' -> currentPosition += rotation.distance();
                case 'L' -> currentPosition -= rotation.distance();
            }
            IO.println(rotation + " " + currentPosition);

            int timesHundred = Math.abs(currentPosition / 100);
            currentPosition %= 100;
            if (currentPosition < 0) {
                currentPosition += 100;
            }
            IO.println("New current position: " + currentPosition);

            if (currentPosition == 0) {
                password++;
            }
        }
        IO.println("Password: " + password);
    }


    private static ArrayList<Rotation> extractRotations(Path uri) throws IOException {
        var entries = new ArrayList<Rotation>();
        try (var scanner = new Scanner(uri)) {
            while (scanner.hasNext()) {
                var entry = scanner.next();
                var rotation = new Rotation(entry.charAt(0), Integer.parseInt(entry.substring(1)));
                entries.add(rotation);
            }
        }
        return entries;
    }
}

record Rotation(char direction, int distance) {
}