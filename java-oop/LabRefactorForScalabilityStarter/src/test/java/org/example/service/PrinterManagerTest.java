package org.example.service;

import org.example.model.Printer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrinterManagerTest {

    private PrinterManager pm;

    @BeforeEach
    public void setup(){
        pm = new PrinterManager();

        Printer p1 = new Printer("Alpha", "1");
        Printer p2 = new Printer("Bravo", "2");
        Printer p3 = new Printer("Charlie", "3");
        pm.addPrinter(p1.getId(), p1);
        pm.addPrinter(p2.getId(), p2);
        pm.addPrinter(p3.getId(), p3);
    }

    @Test
    public void addPrinterAddsAPrinterToTheMap(){
        Printer testPrinter = new Printer("testPrinter", "ab");
        pm.addPrinter("ab", testPrinter);
        assertEquals(testPrinter, pm.getPrinter("ab"));
        // test for correlating printerMonitor???
    }

    @Test
    public void getAllPrinterIDsReturnsCorrectListOfAllPrinters(){
        List<String> ids = pm.getAllPrinterIDs();
        assertEquals(Set.of("1", "2", "3"), Set.copyOf(ids), "IDs do not match");
    }

    @Test
    public void getPrinterIDSize(){
        List<String> ids = pm.getAllPrinterIDs();

        assertEquals(3, ids.size(), "Should return all printer IDs");
    }

    @Test
    public void allPrintersAreHaltedWhenExecuted(){
        //todo
    }

}
