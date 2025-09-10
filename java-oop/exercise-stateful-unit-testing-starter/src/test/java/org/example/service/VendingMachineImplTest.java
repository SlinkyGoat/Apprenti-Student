package org.example.service;

import org.example.model.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineImplTest {

    VendingMachine vm;

    @BeforeEach
    void setUp() {
        vm = new VendingMachineImpl();
        Product apple = new Product("Apple", .25);
        Product candyBar = new Product("Candy Bar", 1.00);
        Product soda = new Product("Soda", .50);

        vm.loadProduct("A1", apple, 1);
        vm.loadProduct("A2", candyBar, 2);
        vm.loadProduct("A3", soda, 10);

        vm.addMoney(1000.0);
    }

    @AfterEach
    void tearDown() {
        // do nothing
    }


    /*
        tests for bug report #1
     */

    @Test
    void lastItemVendDoesNotError(){
        assertDoesNotThrow(() -> vm.vend("A1"));
    }

    @Test
    void secondLastItemVendDoesNotError(){
        assertDoesNotThrow(() -> vm.vend("A2"));
    }

    @Test
    void itemVendDoesNotError(){
        assertDoesNotThrow(() -> vm.vend("A4"));
    }


    /*
        tests for bug report #2
     */
    @Test
     void correctAmountOfMoneyIsTakenFromUserAfterPurchase(){
        vm.vend("A3");
        double actual = vm.getCustomerMoney();
        double expected = 1000 - 0.50;
        assertEquals(expected, actual);
    }

    @Test
    void moneyIsCollectedAfterPurchase(){
        vm.vend("A3");
        double actual = vm.getMoneyBinContents();
        double expected = 0.5;
        assertEquals(expected, actual);
    }

    @Test
    void correctAmountOfMoneyIsCollectedWhenEmptyingMoneyBin(){
        vm.vend("A3");
        vm.vend("A3");
        vm.vend("A3");
        double actual = vm.emptyMoneyBin();
        double expected = 1.50;
        assertEquals(expected, actual);
    }


    /*
        tests for bug report #3
     */
    @Test
    void correctNumberOfItemsAreLoadedIntoMachine(){
        final int AMOUNT_TO_LOAD = 10;
        Product testItem = new Product("TestItem", 2.5);
        vm.loadProduct("A4", testItem, AMOUNT_TO_LOAD);
        int actual = vm.getBinQuantity("A4");
        assertEquals(AMOUNT_TO_LOAD, actual);
    }
}