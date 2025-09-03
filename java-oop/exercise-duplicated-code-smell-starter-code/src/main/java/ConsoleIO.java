import java.util.Scanner;

public class ConsoleIO {
    
    Scanner myScanner = new Scanner(System.in);

    /*
     * ---------------------------
     * BASIC IN/OUT METHODS
     * ---------------------------
     */
    public void writeMessage(String message) {
        System.out.println(message);
    }

    public String getInput(String prompt) {
        System.out.println(prompt);
        return myScanner.nextLine();
    }


    /*
     * ---------------------------
     * GET INTEGER METHODS
     * ---------------------------
     */
    public int getInteger(String prompt) {
        int number = -1;

        while(true) {
            try {
                number = Integer.parseInt(getInput(prompt));
                break;
            } catch(Exception e) {
                System.out.println("Input a valid number");
            }
        }
        return number;
    }

    public int getIntegerInBetween(String prompt, int min, int max) {
        int number = -1;

        while(true) {
            try {
                number = getInteger(prompt);
                if(number >= min && number <= max) {
                    break;
                }
                else {
                    System.out.println("Enter a number between " + min + " and " + max);
                }
            } catch(Exception e) {
                System.out.println("Input a valid number");
            }
        }
        return number;
    }

    public int getIntegerWithRangePrompt(String prompt, int min, int max, String rangePrompt) {
        int number = getInteger(prompt);
        if (number < min || number > max) {
            number = getIntegerInBetween(rangePrompt, min, max);
        }
        return number;
    }


    /*
     * ---------------------------
     * GET DOUBLE METHODS
     * ---------------------------
     */
    public double getMoney() {
        double number = 0.0;

        while(true) {
            try {
                number = Double.parseDouble(getInput("Enter the amount of cash on hand: "));
                break;
            } catch(Exception e) {
                System.out.println("Input a valid number");
            }
        }
        return number;
    }

    public double getPositiveMoney() {
        double number = 0.0;

        while(true) {
            number = getMoney();
            if(number > 0.0) {
                break;
            } else {
                System.out.println("Enter a positive amount of money.");
            }
        }
        return number;
    }


    /*
     * ---------------------------
     * GET STRING METHODS
     * ---------------------------
     */
    public String getNonNullNonEmptyString (String prompt) {
        boolean goodInput = false;
        String result = null;

        while(!goodInput) {
            result = getInput(prompt);
            if(result == null || result.length() <= 0) {
                System.out.println("Enter a valid response.");
            } else {
                goodInput = true;
            }
        }

        return result;
    }

    /*
     * Returns a default String value if user inputs an invalid String
     */
    public String getNonNullNonEmptyStringOrDefault(String prompt, String fallbackMessage, String defaultValue) {
        String result = getInput(prompt);
        if (result == null || result.length() == 0) {
            writeMessage(fallbackMessage);
            return defaultValue;
        }
        return result;
    }


}
