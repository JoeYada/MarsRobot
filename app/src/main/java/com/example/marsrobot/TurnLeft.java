package com.example.marsrobot;

import android.support.annotation.NonNull;

public class TurnLeft implements Command {

    @NonNull
    @Override
    public Robot execute(@NonNull Robot robot) {
        switch (robot.getCurrentDirection()) {
            case EAST:
                robot.setCurrentDirection(Direction.NORTH);
                break;
            case WEST:
                robot.setCurrentDirection(Direction.SOUTH);
                break;
            case NORTH:
                robot.setCurrentDirection(Direction.WEST);
                break;
            case SOUTH:
                robot.setCurrentDirection(Direction.EAST);
                break;
        }
        return robot;
    }
}
