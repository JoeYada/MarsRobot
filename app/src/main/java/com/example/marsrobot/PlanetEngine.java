package com.example.marsrobot;

import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PlanetEngine implements Robot.OnRobotLostListener {
    @Nullable
    private Robot currentRobot = null;
    private final Edge currentEdge;
    private final List<Coordinate> markedCoordinates;

    public PlanetEngine(int upperCoordinate, int rightCoordinate) {
        markedCoordinates = new ArrayList<>();
        currentEdge = new Edge(0, rightCoordinate, 0, upperCoordinate);
    }
    public void initRobot(int startX, int startY, Direction direction) {
        currentRobot = new Robot(direction, startX, startY, currentEdge, markedCoordinates, this);
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

    @Override
    public void onRobotLost(Coordinate coordinate) {
        markedCoordinates.add(coordinate);
    }
}
