package org.montiholl;

import java.util.Random;

public class MontyHall {
    public static final Random gen = new Random();

    /** chooses a random door other than door1 or door2 */
    public static int chooseAnotherDoor(int door1, int door2) {
        int result;
        do
            result = gen.nextInt(3);
        while (result == door1 || result == door2);
        return result;
    }
}
