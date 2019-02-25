package com.example.marsrobot;

public class Edge {
    private final int xFloor;
    private final int xCeiling;
    private final int yFloor;
    private final int yCeiling;

    public Edge(int xFloor, int xCeiling, int yFloor, int yCeiling) {
        this.xFloor = xFloor;
        this.xCeiling = xCeiling;
        this.yFloor = yFloor;
        this.yCeiling = yCeiling;
    }

    public int getXFloor() {
        return xFloor;
    }

    public int getXCeiling() {
        return xCeiling;
    }

    public int getYFloor() {
        return yFloor;
    }

    public int getYCeiling() {
        return yCeiling;
    }
}
