public class TrafficLightSystem {
    public static void main(String[] args) {
    //Traffic lights are programmed using an indexed array.

    //1. Create an enum named TrafficLight with values:
        //RED
        //YELLOW
        //GREEN
        enum TrafficLight {
            RED,
            YELLOW,
            GREEN,
        }

        TrafficLight[] lights = TrafficLight.values();

        int userInput = 1;
        System.out.println("Traffic light signal: " + lights[userInput]);


    //2. Store all values in an array using values().

    //3. Retrieve the correct signal based on a predefined index (1 for YELLOW).

    //4. Print the selected signal.


    }
}
