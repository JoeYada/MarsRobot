package com.example.marsrobot;

public class Robot {
    private Direction currentDirection;
    private int xPos;
    private int yPos;

    public Robot(Direction currentDirection, int xPos, int yPos) {
        this.currentDirection = currentDirection;
        this.xPos = xPos;
        this.yPos = yPos;
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
}
