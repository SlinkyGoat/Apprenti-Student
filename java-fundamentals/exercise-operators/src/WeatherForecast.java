public class WeatherForecast {
    public static void main(String[] args) {
//        Declare and initialize variables:
        double temperatureCelsius = 25.0;
        boolean isRaining = false;
        int windSpeedKmh = 10;

//        1. Convert Celsius to Fahrenheit using the formula:
//              temperatureFahrenheit = (temperatureCelsius×9/5) + 32
        double temperatureFahrenheit = (temperatureCelsius * (9.0/5.0)) + 32;

//        2. Use Assignment Operators:
//               Increase temperature by 5 degrees (+=).
//               Increase wind speed by 5 km/h (+=).
        temperatureCelsius += 5;
        windSpeedKmh += 5;
//        3. Use Comparison Operators:
//               Check if the temperature in Fahrenheit exceeds 85°F.
//               Check if the wind speed is greater than 20 km/h.
        temperatureFahrenheit = (temperatureCelsius * (9.0/5.0)) + 32;
        boolean isHot = temperatureFahrenheit > 85.0;
        boolean isWindy = windSpeedKmh > 20;
//        4. Use Logical Operators:
//               Determine if it's a good day to go outside (not raining AND temperature
//               between 60°F - 85°F).
        boolean isGoodDay = !isRaining && temperatureFahrenheit >= 60.0 && temperatureFahrenheit <= 85.0;
//    Determine if there's a weather warning (wind speed above 30 km/h OR
//        temperature below 0°C).
        boolean isWeatherWarning = windSpeedKmh > 30 || temperatureCelsius < 0.0;
//        5. Print the results in a readable format.

        System.out.println("It is above 85°F: " + isHot);
        System.out.println("The wind speed is above 20 km/h: " + isWindy);
        System.out.println("It isn't raining and the temperature is between 60°F - 85°F: " + isGoodDay);
        System.out.println("There is a weather warning for high speeds or cold weather: " + isWeatherWarning);
//
    }
}
