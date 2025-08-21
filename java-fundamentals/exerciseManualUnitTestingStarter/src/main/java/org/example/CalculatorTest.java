package org.example;

public class CalculatorTest {

    public static void main(String[] args) {

        // setup
        Calculator testCalculator = new Calculator();
        int[] numbers;
        int result;
        // test
        System.out.println("***************ADDITION***************");
        // 1. add 2 numbers
        numbers = new int[] {4,4};
        result = testCalculator.add(numbers);
        test("4+4", 8, result);

        // 2. add 4 numbers
        numbers = new int[] {5, 5, 5, 5};
        result = testCalculator.add(numbers);
        test("5+5+5+5", 20, result);

        // 3. add 1 number
        numbers = new int[] {7};
        result = testCalculator.add(numbers);
        test("7", 7, result);

        // 4. add null
        numbers = null;
        result = testCalculator.add(numbers);
        test("null", 0, result);

        // 5. add zeros
        numbers = new int[] {0, 0, 0, 0, 0};
        result = testCalculator.add(numbers);
        test("0+0+0+0+0", 0, result);

        // 6. empty array
        numbers = new int[] {};
        result = testCalculator.add(numbers);
        test("empty", 0, result);

        System.out.println("***************SUBTRACTION***************");
        // 1. subtract 2 numbers
        numbers = new int[] {10,5};
        result = testCalculator.subtract(numbers);
        test("10-5", 5, result);

        // 2. subtract 4 numbers
        numbers = new int[] {20, 4, 4, 4};
        result = testCalculator.subtract(numbers);
        test("20-4-4-4", 8, result);

        // 3. subtract 1 number
        numbers = new int[] {5};
        result = testCalculator.subtract(numbers);
        test("5", 5, result);

        // 4. subtract null
        numbers = null;
        result = testCalculator.subtract(numbers);
        test("null", 0, result);

        // 5. subtract zeros
        numbers = new int[] {0,0,0,0};
        result = testCalculator.subtract(numbers);
        test("0-0-0-0", 0, result);

        // 6. empty array
        numbers = new int[] {};
        result = testCalculator.subtract(numbers);
        test("empty", 0, result);


        // tear down

    }

    public static void test(String prompt, int expected, int actual){
        if(expected == actual){
            System.out.println("TEST PASSED: " + prompt + " = " + actual);
            System.out.println();
        } else {
            System.out.println("TEST FAILED for " + prompt);
            System.out.println("Expected=" + expected);
            System.out.println("Actual=" + actual);
            System.out.println();
        }
    }

}
