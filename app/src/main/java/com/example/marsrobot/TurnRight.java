package com.example.marsrobot;

import android.support.annotation.NonNull;

public class TurnRight implements Command {
    @Override
    @NonNull
    public Robot execute(Robot robot) {
        switch (robot.getCurrentDirection()) {
            case EAST:
                robot.setCurrentDirection(Direction.SOUTH);
                break;
            case WEST:
                robot.setCurrentDirection(Direction.NORTH);
                break;
            case NORTH:
                robot.setCurrentDirection(Direction.EAST);
                break;
            case SOUTH:
                robot.setCurrentDirection(Direction.WEST);
                break;
        }
        return robot;
    }
}
