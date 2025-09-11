package org.example.model;

public class Printer {
    public enum PrinterStatus {
        READY,
        WARMING_UP,
        PRINTING,
        COMPLETE,
        HALT
    }

    private String name;
    private String id;
    private PrinterStatus status;
    private String printModelName;
    public static final int cyclesPerWarmup = 1;
    public static final int cyclesPerPrint = 2;

    public Printer(String name, String id) {
        setName(name);
        setId(id);
        setStatus(PrinterStatus.READY);
    }
    public PrinterStatus getStatus() {
        return status;
    }

    public void setStatus(PrinterStatus status) {
        this.status = status;
    }

    public String getPrintModelName() {
        return printModelName;
    }

    public void setPrintModelName(String printModelName){
        this.printModelName = printModelName;
    }

    public void print(String printModelName) {
        setPrintModelName(printModelName);
        this.status = PrinterStatus.WARMING_UP;
        System.out.println(toString() + " - Printing " + printModelName);
//        this.status = PrinterStatus.READY;
    }

    public void clearBed() {
        printModelName = null;
        status = PrinterStatus.READY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId(){
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String toString() {
        return name + ": " + status;
    }
}