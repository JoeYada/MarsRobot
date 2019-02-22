package com.example.marsrobot;

import android.support.annotation.Nullable;

public class PlanetEngine {
    @Nullable
    private Robot currentRobot = null;

    public void initRobot(int startX, int startY, Direction direction) {
        currentRobot = new Robot(direction, startX, startY);
    }
}
