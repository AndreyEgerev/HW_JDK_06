package org.montiholl;

import java.util.Random;
import static org.montiholl.MontyHall.*;

public class Main {
    public static final int ROUNDS = 10_000;
    public static final Random gen = new Random();

    public static void main(String[] args) {
        System.out.println(ROUNDS);
        System.out.println("begin playing " + ROUNDS + " rounds");

        int winsSwitch = 0;
        int winsNotSwitch = 0;
        for (int i = 0; i < ROUNDS; i++) {
            int prize = gen.nextInt(3);
            int userChoice1 = gen.nextInt(3);
            // открывает случайную дверь за которой нет приза.
            int hostChoice = chooseAnotherDoor(prize, userChoice1);
            // игрок сменил дверь
            int userChoice2 = chooseAnotherDoor(userChoice1, hostChoice);
            if (userChoice2 == prize)
                winsSwitch++;
            // Игрок оставил выбранную дверь
            if (userChoice1 == prize)
                winsNotSwitch++;
        }

        System.out.println(winsSwitch + " wins by switching");
        System.out.println(winsNotSwitch + " wins by not switching");
        System.out.println("All " + (winsSwitch + winsNotSwitch));
    }
}