package com.example.marsrobot;

public class GoForward implements Command {
    @Override
    public Robot execute(Robot robot) {
        switch (robot.getCurrentDirection()) {
            case EAST:
                robot.setxPos(robot.getxPos() + 1);
                break;
            case WEST:
                robot.setxPos(robot.getxPos() - 1);
                break;
            case NORTH:
                robot.setyPos(robot.getyPos() + 1);
                break;
            case SOUTH:
                robot.setyPos(robot.getyPos() - 1);
                break;
        }
        return robot;
    }
}
