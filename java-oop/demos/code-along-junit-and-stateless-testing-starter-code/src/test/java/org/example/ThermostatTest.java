package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ThermostatTest {

    // setup
    private Thermostat testThermostat;
    private final int TEMPERATURE = 72;
    private final int TOLERANCE = 2;

    @BeforeEach
    void setup(){
        // Create a new Thermostat
        testThermostat = new Thermostat();
        testThermostat.setTargetTemperature(TEMPERATURE);
        testThermostat.setTolerance(TOLERANCE);
    }

    // assert
    // 1. Heat on when temp is low
    @Test
    public void tempLowHeatShouldBeOn(){
        // arrange
        int[] temperatures = {72, 70, 68, 69, 70};
        // act
        Thermostat.ThermostatBehavior expectedResult = Thermostat.ThermostatBehavior.ON_HEAT;
        Thermostat.ThermostatBehavior actualResult = testThermostat.readSensorData(temperatures);
        // assert
        assertEquals(expectedResult, actualResult);
    }

    // 2. AC on when temp is high
    @Test
    public void tempHighAcShouldBeOn(){
        // arrange
        int[] temperatures = {77, 75, 74, 74, 76};
        // act
        Thermostat.ThermostatBehavior expectedResult = Thermostat.ThermostatBehavior.ON_AC;
        Thermostat.ThermostatBehavior actualResult = testThermostat.readSensorData(temperatures);
        // assert
        assertEquals(expectedResult, actualResult);
    }

    // 3. system off when temp is just right (within 2 degrees)
    @Test
    public void tempRightSystemShouldBeOff(){
        // arrange
        int[] temperatures = {75, 73, 72, 72, 74};
        // act
        Thermostat.ThermostatBehavior expectedResult = Thermostat.ThermostatBehavior.OFF;
        Thermostat.ThermostatBehavior actualResult = testThermostat.readSensorData(temperatures);
        // assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getTempReturnsCorrectTemp(){
        int actualResult = testThermostat.getTargetTemperature();

        assertEquals(TEMPERATURE, actualResult);
    }

    @Test
    public void getToleranceReturnsCorrectTolerance(){
        int actualResult = testThermostat.getTolerance();

        assertEquals(TOLERANCE, actualResult);
    }

    // tear down

}
