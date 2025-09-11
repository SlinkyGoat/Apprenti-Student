package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrinterTest {

    private Printer p;

    @BeforeEach
    public void setup(){
        p = new Printer("Alpha", "1");
    }

    @Test
    public void clearBedEmptiesModelName(){
        p.setPrintModelName("testing");
        assertEquals("testing", p.getPrintModelName());
        p.clearBed();
        assertNull(p.getPrintModelName());
    }

    @Test
    public void clearBedSetsStatusToReady(){
        p.setPrintModelName("testing");
        p.setStatus(Printer.PrinterStatus.COMPLETE);
        p.clearBed();
        assertEquals(Printer.PrinterStatus.READY, p.getStatus());
    }


}