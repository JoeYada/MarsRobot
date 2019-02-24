package com.example.marsrobot;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Robot {
    private Direction currentDirection;
    private int xPos;
    private int yPos;
    private final Queue<Command> commands;

    public Robot(Direction currentDirection, int xPos, int yPos) {
        this.currentDirection = currentDirection;
        this.xPos = xPos;
        this.yPos = yPos;
        commands = new LinkedList<>();
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void executeCommands() {
        for (Command command : commands) {
            command.execute(this);
        }
    }

    public String getFinalState() {
        return String.valueOf(xPos) + " " + String.valueOf(yPos) + " " + currentDirection.toString().charAt(0);
    }
}
