package org.example.service;

import org.example.model.Printer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PrinterManager {
    
    private Map<String, Printer> printers;
    private List<PrinterMonitor> monitors;

    public PrinterManager() {
        this.printers = new LinkedHashMap<String, Printer>();
        this.monitors = new ArrayList<PrinterMonitor>();
    }

    public void addPrinter(String key, Printer printer){
        printers.put(key, printer);
    }

    public Printer getPrinter(String key){

        return printers.get(key);
    }

    public List<String> getAllPrinterIDs(){
        // TODO
        /*
        return list of Strings from printers
         */
        return null;
    }

    public void haltMonitors(){
        // TODO
        /*
        add HALTED status to printer
        set all printers to halted
         */
    }
}
