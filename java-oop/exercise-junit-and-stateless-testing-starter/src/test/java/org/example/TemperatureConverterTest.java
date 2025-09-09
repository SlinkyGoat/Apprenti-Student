package org.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemperatureConverterTest {
    private TemperatureConverter converter;

    private final double FAHRENHEIT_TEMPERATURE = 77.0;
    private final double CELSIUS_TEMPERATURE = 25.0;
    private final double KELVIN_TEMPERATURE = 298.15;

    @BeforeEach
    public void setup(){
        converter = new TemperatureConverter();
    }

    @Test
    public void FahrenheitToCelsius(){
        double actualResult = converter.fahrenheitToCelsius(FAHRENHEIT_TEMPERATURE);
        assertEquals(CELSIUS_TEMPERATURE, actualResult);
    }

    @Test
    public void FahrenheitToKelvin(){
        double actualResult = converter.fahrenheitToKelvin(FAHRENHEIT_TEMPERATURE);
        assertEquals(KELVIN_TEMPERATURE, actualResult);
    }

    @Test
    public void CelsiusToFahrenheit(){
        double actualResult = converter.celsiusToFahrenheit(CELSIUS_TEMPERATURE);
        assertEquals(FAHRENHEIT_TEMPERATURE, actualResult);
    }

    @Test
    public void CelsiusToKelvin(){
        double actualResult = converter.celsiusToKelvin(CELSIUS_TEMPERATURE);
        assertEquals(KELVIN_TEMPERATURE, actualResult);
    }

    @Test
    public void KelvinToCelsius(){
        double actualResult = converter.kelvinToCelsius(KELVIN_TEMPERATURE);
        assertEquals(CELSIUS_TEMPERATURE, actualResult);
    }

    @Test
    public void KelvinToFahrenheit(){
        double actualResult = converter.kelvinToFahrenheit(KELVIN_TEMPERATURE);
        assertEquals(FAHRENHEIT_TEMPERATURE, actualResult);
    }


}