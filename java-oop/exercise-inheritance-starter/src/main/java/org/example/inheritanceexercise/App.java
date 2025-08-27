package org.example.inheritanceexercise;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Payment> payments = new ArrayList<>();

        //Create your sample payments here
        Payment p1 = new CreditCard(1000, 550, 432895925, "BMO Harris");
        Payment p2 = new DirectDebit(1001, 250, 917827503, 123456789, "Bank of America", 15.0);
        Payment p3 = new GiftCard(1002, 725, "936152758", 500, 1400);
        Payment p4 = new CreditCard(1003, 1800, 256239856, "Chase");
        Payment p5 = new DirectDebit(1004, 55, 192837465, 987654321, "Citibank", 25.0);
        Payment p6 = new GiftCard(1005, 20, "027830017", 1500, 7000);

        payments.add(p1);
        payments.add(p2);
        payments.add(p3);
        payments.add(p4);
        payments.add(p5);
        payments.add(p6);


        //Payments Report
        for (Payment p : payments) {
            System.out.println(p.toString());
        }

        //Payment Processing Report
        for (Payment p : payments) {
            p.processPayment();
        }


        //Uncomment this section after implementing GiftCardPayment to verify that balances are correct after processing
//        //Post processing gift card balance check
        for (Payment p : payments) {
            if (p instanceof GiftCard) {
                System.out.println(p.toString());
            }
        }
    }
}
