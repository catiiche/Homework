package com.itmo.shkuratova.coursework3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * class StepChoice extends Step
 *
 * receives and handle information from the player to which node he wants to get
 *
 * @author Kate Shkuratova
 * @version 1.1
 * @see Step
 * @see ChainNodes
 */
public class StepChoice extends Step {

    public StepChoice(String state, String text) {

        super(state, text);
    }


    @Override
    public int handleChoice() {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("\n" + getText());

            System.out.println("Press 1: " + firstChoice.getGameState()
                    + "\nPress 2: " + secondChoice.getGameState()
                    + "\nPress 3 if you prefer back to the menu\n");

            int choiceNumber = Integer.parseInt(reader.readLine());

            if (choiceNumber == 1 || choiceNumber == 2) return choiceNumber;
            return 3;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 3;
    }
}
