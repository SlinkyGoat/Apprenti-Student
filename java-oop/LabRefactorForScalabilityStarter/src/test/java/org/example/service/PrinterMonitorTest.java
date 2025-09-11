package org.example.service;

import org.example.model.Printer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrinterMonitorTest {

    private PrinterMonitor pm;
    private Printer p;

    @BeforeEach
    public void setup(){
        p = new Printer("Alpha", "A");
        pm = new PrinterMonitor(p);
    }

    /*
    HANDLE READY TESTS
     */
    @Test
    public void handleReadySetsCycleToZero(){
        pm.cycle = 10;
        p.setStatus(Printer.PrinterStatus.READY);
        pm.run();
        assertEquals(0, pm.cycle);
    }

    /*
    HANDLE WARMUP TESTS
     */
    @Test
    public void increaseCycleIfZeroDuringWarmup(){
        pm.cycle = 0;
        p.setStatus(Printer.PrinterStatus.WARMING_UP);
        pm.run();
        assertEquals(1, pm.cycle);
    }

    @Test
    public void setStatusToPrintingIfCycleIsGreaterThanOrEqualToCyclesPerWarmup(){
        // Printer.cyclesPerWarmup = 1
        pm.cycle = 1;
        p.setStatus(Printer.PrinterStatus.WARMING_UP);
        pm.run();
        assertEquals(Printer.PrinterStatus.PRINTING, p.getStatus());
    }

    @Test
    public void resetCycleToZeroAfterWarmup(){
        // Printer.cyclesPerWarmup = 1
        pm.cycle = 1;
        p.setStatus(Printer.PrinterStatus.WARMING_UP);
        pm.run();
        assertEquals(0, pm.cycle);
    }

    /*
    HANDLE PRINTING TESTS
     */
    @Test
    public void increaseCyclesIfLessThanCyclesPerPrint(){
        // Printer.cyclesPerPrint = 2
        pm.cycle = 1;
        p.setStatus(Printer.PrinterStatus.PRINTING);
        pm.run();
        assertEquals(2, pm.cycle);
    }

    @Test
    public void setStatusToCompleteIfCycleIsGreaterThanOrEqualToCyclesPerPrint(){
        // Printer.cyclesPerPrint = 2
        pm.cycle = 2;
        p.setStatus(Printer.PrinterStatus.PRINTING);
        pm.run();
        assertEquals(Printer.PrinterStatus.COMPLETE, p.getStatus());
    }

    @Test
    public void resetCycleToZeroAfterPrint(){
        // Printer.cyclesPerPrint = 2
        pm.cycle = 2;
        p.setStatus(Printer.PrinterStatus.WARMING_UP);
        pm.run();
        assertEquals(0, pm.cycle);
    }


    /*
    HANDLE COMPLETE TESTS
     */
    @Test
    public void resetCycleAfterComplete(){
        pm.cycle = 10;
        p.setStatus(Printer.PrinterStatus.COMPLETE);
        pm.run();
        assertEquals(0, pm.cycle);
    }

    /*
    HALT MONITORS TESTS
     */
    @Test
    public void haltMonitorSetsStatusToHalt(){
        pm.haltMonitor();
        assertEquals(Printer.PrinterStatus.HALT, p.getStatus());
    }

}
