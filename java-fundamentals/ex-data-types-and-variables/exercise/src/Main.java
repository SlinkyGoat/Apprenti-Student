
public class Main {
    public static void main(String[] args) {
        System.out.println("Exercise Code Starts Here:");


        //Sports Statistics
        //1 Declare and assign the following variables related to a soccer player:
        //2 playerName → store the name of a soccer player.
        String playerName = "Lionel Messi";
        //3 jerseyNumber → store the player's jersey number.
        int jerseyNumber = 10;
        //4 position → store the player’s field position (e.g., "Goalkeeper").
        String position = "Forward";
        //5 isStarter → store whether the player is a starter (true or false).
        boolean isStarter = false;
        //6 teamName → store the name of the player’s team.
        String teamName = "Inter Miami CF";


        //Movie Information
        //1 Declare and assign the following variables for a movie:
        //2 movieTitle → store the title of a movie.
        String movieTitle = "Happy Gilmore";
        //3 releaseYear → store the year the movie was released.
        int releaseYear = 1996;
        //4 rating → store the rating (e.g., "PG-13").
        String rating = "PG-13";
        //5 isSequel → store whether the movie has a sequel (true or false).
        boolean isSequel = true;
        //6 leadActor → store the name of the lead actor.
        String leadActor = "Adam Sandler";


        //Weather Report
        //1. Declare and assign the following variables for a weather forecast:
        //2. cityName → store the name of a city.
        String cityName = "Milwaukee";
        //3. temperature → store the temperature in Fahrenheit.
        int temperature = 79;
        //4. isRaining → store whether it is currently raining (true or false).
        boolean isRaining = false;
        //5. humidity → store the humidity percentage.
        double humidity = 0.77;
        //6. weatherCondition → store a short description of the weather (e.g. "Cloudy").
        String weatherCondition = "Cloudy";



        //Flight Information
        //1 Declare and assign the following variables for a flight at an airport:
        //2 flightNumber → store the flight number (e.g., "AA256").
        int flightNumber = 6360;
        //3 departureCity → store the departure city (e.g., "New York").
        String departureCity = "Milwaukee";
        //4 arrivalCity → store the arrival city (e.g., "Los Angeles").
        String arrivalCity = "Chicago";
        //5 gateNumber → store the gate number for the flight.
        String gateNumber = "D56";
        //6 terminal → store the terminal number at the airport.
        int terminal = 12;
        //7 isDelayed → store whether the flight is delayed (true or false).
        boolean isDelayed = false;



        //Part 2: Printing Variables
        // Use System.out.println() to print each set of variables.
        // Format the output to display meaningful sentences

        // soccer player
        System.out.print(teamName + " player " + playerName + ", number " + jerseyNumber + ", plays " + position + " and is ");
        if(!isStarter){
            System.out.print("not ");
        }
        System.out.println("a starter player.");

        // movie
        System.out.print("The movie " + movieTitle + " released all the way back in " + releaseYear + ". ");
        System.out.print("The innuendo-filled movie starring " + leadActor + " has a " + rating + " rating. ");
        if (isSequel){
            System.out.println("The sensational movie came out with a sequel.");
        } else {
            System.out.println("This comedic movie never came out with a sequel.");
        }

        // weather
        System.out.print("It is ");
        if(!isRaining){
            System.out.print("not ");
        }
        System.out.print("raining in " + cityName + " with a current temperature of " +
                temperature + " degrees Fahrenheit, and a humidity of " + (int) (humidity * 100) + "%. ");
        System.out.println("It is currently " + weatherCondition + ".");

        // flights
        System.out.print("You're flight number is " + flightNumber + ". This flight departs from" +
                departureCity + " and wikll arrive in " + arrivalCity + ". To find gate " +
                gateNumber + " through terminal " + terminal + ". ");
        if(isDelayed) {
            System.out.println("Please find seating somewhere as the flight is delayed.");
        } else {
            System.out.println("The flight currently has no delays, please ensure you arrive on-time!");
        }

        // PART 3
        jerseyNumber = 33;
        isStarter = true;
        rating = "R";
        isSequel = false;
        temperature = 55;
        weatherCondition = "Sunny";
        gateNumber = "E12";
        isDelayed = true;

        // printing everything again from part 2 with update values

        // soccer player
        System.out.print(teamName + " player " + playerName + ", number " + jerseyNumber + ", plays " + position + " and is ");
        if(!isStarter){
            System.out.print("not ");
        }
        System.out.println("a starter player.");

        // movie
        System.out.print("The movie " + movieTitle + " released all the way back in " + releaseYear + ". ");
        System.out.print("The innuendo-filled movie starring " + leadActor + " has a " + rating + " rating. ");
        if (isSequel){
            System.out.println("The sensational movie came out with a sequel.");
        } else {
            System.out.println("This comedic movie never came out with a sequel.");
        }

        // weather
        System.out.print("It is ");
        if(!isRaining){
            System.out.print("not ");
        }
        System.out.print("raining in " + cityName + " with a current temperature of " +
                temperature + " degrees Fahrenheit, and a humidity of " + (int) (humidity * 100) + "%. ");
        System.out.println("It is currently " + weatherCondition + ".");

        // flights
        System.out.print("You're flight number is " + flightNumber + ". This flight departs from" +
                departureCity + " and wikll arrive in " + arrivalCity + ". To find gate " +
                gateNumber + " through terminal " + terminal + ". ");
        if(isDelayed) {
            System.out.println("Please find seating somewhere as the flight is delayed.");
        } else {
            System.out.println("The flight currently has no delays, please ensure you arrive on-time!");
        }


        // PART 4
        boolean hasHomework = true;
        boolean isWeekend = false;
        boolean attendedClass = true;
        if(hasHomework){
            System.out.println("I have homework today.");
        } else{
            System.out.println("I do not have homework today.");
        }

        if(isWeekend){
            System.out.println("It is the weekend.");
        } else{
            System.out.println("It is not the weekend.");
        }

        if(attendedClass){
            System.out.println("I attended class today.");
        } else{
            System.out.println("I did not attend class today.");
        }


        // PART 5
        char firstInitial = 'A';
        char lastInitial = 'U';
        char favoriteGrade = 'F'; // I want to be different!
        System.out.println("My name is Adam Ustby so my initials are " + firstInitial + "." +
                lastInitial + ". and my favorite grade to get in class is a " + favoriteGrade + "!");
    }
}