package org.example.service;

import org.example.model.Printer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrinterManagerTest {

    private PrinterManager pm;

    @BeforeEach
    public void setup(){
        pm = new PrinterManager();
    }

    @Test
    public void addPrinterAddsAPrinterToTheMap(){
        Printer testPrinter = new Printer("testPrinter");
        pm.addPrinter("ab", testPrinter);
        assertEquals(testPrinter, pm.getPrinter("ab"));
    }

    @Test
    public void getAllPrinterIDsReturnsCorrectListOfAllPrinters(){

    }

}
