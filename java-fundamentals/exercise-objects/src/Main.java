

public class Main {

    public static void main(String[] args) {
        Car car1 = new Car("Chrysler", "200", 2013);
        Car car2 = new Car("Hyundai", "Santa-Fe", 2022);
        Car car3 = new Car("Chrysler", "200", 2013);
        String car1Display = car1.displayInfo();
        String car2Display = car2.displayInfo();
        System.out.println(car1Display);
        System.out.println(car2Display);
        System.out.println(car1 == car3);
        System.out.println(car1.equals(car3));
    }

}
