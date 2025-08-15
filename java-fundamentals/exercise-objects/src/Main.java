import org.w3c.dom.ls.LSOutput;

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

        System.out.println("-----------------------------");

        Book book1 = new Book("The Hobbit", "Tolkien");
        Book book2 = new Book("The Lord of the Rings", "Tolkien", false);
        Book book3 = new Book();
        System.out.println(book1.isAvailable);
        // try to borrow book1
        if(book1.isAvailable) {
            book1.borrowBook();
        } else {
            System.out.println("Book unavailable");
        }
        // try to borrow book2
        if(book2.isAvailable) {
            book2.borrowBook();
        } else {
            System.out.println("Book unavailable");
        }
        book1.borrowBook();
        System.out.println(book1.isAvailable);

        System.out.println("-----------------------------");

        BankAccount account = new BankAccount("Rocco", 500.00);
        BankAccount myAccount = account;
        System.out.println(account.getBalance());
        System.out.println(myAccount.getBalance());
        account.deposit(100.00);
        System.out.println(account.getBalance());
        System.out.println(myAccount.getBalance());
    }

}
