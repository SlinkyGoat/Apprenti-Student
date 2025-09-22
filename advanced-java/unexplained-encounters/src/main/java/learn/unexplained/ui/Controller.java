package learn.unexplained.ui;

import learn.unexplained.data.DataAccessException;
import learn.unexplained.domain.EncounterResult;
import learn.unexplained.domain.EncounterService;
import learn.unexplained.models.Encounter;
import learn.unexplained.models.EncounterType;

import java.util.List;

public class Controller {

    private final EncounterService service;
    private final View view;

    public Controller(EncounterService service, View view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        view.printHeader("Welcome To Unexplained Encounters.");

        try {
            runMenuLoop();
        } catch (DataAccessException ex) {
            view.printHeader("CRITICAL ERROR:" + ex.getMessage());
        }

        view.printHeader("Goodbye");
    }

    private void runMenuLoop() throws DataAccessException {
        MenuOption option;
        do {
            option = view.displayMenuGetOption();
            switch (option) {
                case DISPLAY_ALL:
                    displayAllEncounters();
                    break;
                case ADD:
                    addEncounter();
                    break;
                case DISPLAY_BY_TYPE:
                    displayEncountersByType();
                    break;
                case UPDATE:
                    update();
                    break;
                case DELETE:
                    delete();
                    break;
            }
        } while (option != MenuOption.EXIT);
    }

    private void displayAllEncounters() throws DataAccessException {
        List<Encounter> encounters = service.findAll();
        view.printAllEncounters(encounters);
    }

    private void addEncounter() throws DataAccessException {
        Encounter encounter = view.makeEncounter();
        EncounterResult result = service.add(encounter);
        view.printResult(result);
    }

    private void displayEncountersByType() throws DataAccessException{
        EncounterType type = view.getType();
        List<Encounter> encountersByType = service.findByType(type);
        view.printAllEncounters(encountersByType);
    }

    private void update() throws DataAccessException {
        int id = view.getEncounterId();
        Encounter encounter = service.findById(id).getPayload();
        encounter = view.updateEncounter(encounter);
        EncounterResult result = service.update(encounter);
        view.printResult(result);
    }

    private void delete() throws DataAccessException{
        int id = view.getEncounterId();
        if(service.deleteById(id)){
            view.writeMessage("Encounter " + id + " successfully deleted.");
        } else {
            view.writeMessage("Encounter " + id + " does not exist.");
        }
    }

}
