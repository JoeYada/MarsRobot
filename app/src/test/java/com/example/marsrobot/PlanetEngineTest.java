package com.example.marsrobot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlanetEngineTest {

    private PlanetEngine planetEngine;

    @Before
    public void setup() {
        planetEngine = new PlanetEngine();
    }

    @Test
    public void testExampleInputs() {
        planetEngine.initRobot(1, 1, Direction.EAST);
        Assert.assertEquals("1 1 E", planetEngine
                .processCommandsAndGetFinalState("RFRFRFRF"));
    }
}
