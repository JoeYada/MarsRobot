package com.example.marsrobot;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Robot {
    private Direction currentDirection;
    private int xPos;
    private int yPos;
    private final Queue<Command> commands;
    private boolean isLost;
    private final Edge currentEdge;
    private final List<Coordinate> markedCoordinates;
    private final OnRobotLostListener listener;

    public Robot(Direction currentDirection, int xPos, int yPos, Edge edge,
                 List<Coordinate> markedCoordinates, OnRobotLostListener listener) {
        this.currentDirection = currentDirection;
        this.xPos = xPos;
        this.yPos = yPos;
        this.currentEdge = edge;
        this.markedCoordinates = markedCoordinates;
        this.listener = listener;
        commands = new LinkedList<>();
        isLost = false;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        if (!isLost) {
            this.currentDirection = currentDirection;
        }
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        if(isLost) {
            return;
        }
        if (isAMarkedCoordinate(xPos, true)) {
            return;
        }
        if (xPos < currentEdge.getXFloor() || xPos > currentEdge.getXCeiling()) {
            isLost = true;
            listener.onRobotLost(new Coordinate(xPos, -100));
            return;
        }
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        if(isLost) {
            return;
        }
        if (isAMarkedCoordinate(yPos, false)) {
            return;
        }
        if (yPos < currentEdge.getYFloor() || yPos > currentEdge.getYCeiling()) {
            isLost = true;
            listener.onRobotLost(new Coordinate(-100, yPos));
            return;
        }
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
        String result = String.valueOf(xPos) + " " + String.valueOf(yPos) + " " +
                currentDirection.toString().charAt(0);
        if (isLost) {
            result = result +  " LOST";
        }
        return result;
    }

    private boolean isAMarkedCoordinate(int pos, boolean isX) {
        for (Coordinate coordinate : markedCoordinates) {
            if (isX &&coordinate.getXPos() == pos) {
                return true;
            }
            if (!isX && coordinate.getYPos() == pos) {
                return true;
            }
        }
        return false;
    }

    interface OnRobotLostListener {
        void onRobotLost(Coordinate coordinate);
    }
}
