package com.example.marsrobot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlanetEngineTest {

    private PlanetEngine planetEngine;

    @Before
    public void setup() {
        planetEngine = new PlanetEngine(3, 5);
    }

    @Test
    public void testExampleInputs() {
        planetEngine.initRobot(1, 1, Direction.EAST);
        Assert.assertEquals("1 1 E", planetEngine
                .processCommandsAndGetFinalState("RFRFRFRF"));
    }

    @Test
    public void testLostFunctionality() {
        planetEngine.initRobot(3, 2, Direction.NORTH);
        Assert.assertEquals("3 3 N LOST", planetEngine
        .processCommandsAndGetFinalState("FRRFLLFFRRFLL"));
    }

    @Test
    public void testLostAndScent() {
        //Given
        planetEngine.initRobot(3, 2, Direction.NORTH);
        planetEngine.processCommandsAndGetFinalState("FRRFLLFFRRFLL");
        //When
        planetEngine.initRobot(0, 3, Direction.WEST);
        //Then
        Assert.assertEquals("2 3 S", planetEngine
            .processCommandsAndGetFinalState("LLFFFLFLFL"));
    }


}
