package com.example.marsrobot;

import android.support.annotation.Nullable;

public class PlanetEngine {
    @Nullable
    private Robot currentRobot = null;



    public void initRobot(int startX, int startY, Direction direction) {
        currentRobot = new Robot(direction, startX, startY);
    }

    public String processCommandsAndGetFinalState(String input) {
        char[] commands = input.toCharArray();
        if (currentRobot == null) {
            throw new IllegalStateException("Please initialise Robot before using it");
        }
        for (char command  : commands) {
            switch (command) {
                case 'L':
                    currentRobot.addCommand(new TurnLeft());
                    break;
                case 'R':
                    currentRobot.addCommand(new TurnRight());
                    break;
                case 'F':
                    currentRobot.addCommand(new GoForward());
                    break;
            }
        }
        currentRobot.executeCommands();
        return currentRobot.getFinalState();
    }

}
