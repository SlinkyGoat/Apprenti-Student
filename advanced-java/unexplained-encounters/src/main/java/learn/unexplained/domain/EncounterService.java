package learn.unexplained.domain;

import learn.unexplained.data.DataAccessException;
import learn.unexplained.data.EncounterRepository;
import learn.unexplained.models.Encounter;
import learn.unexplained.models.EncounterType;

import java.util.List;
import java.util.Objects;

public class EncounterService {

    private final EncounterRepository repository;

    public EncounterService(EncounterRepository repository) {
        this.repository = repository;
    }

    public List<Encounter> findAll() throws DataAccessException {
        return repository.findAll();
    }

    public EncounterResult add(Encounter encounter) throws DataAccessException {
        EncounterResult result = validate(encounter);
        if (!result.isSuccess()) {
            return result;
        }

        // check for duplicate
        List<Encounter> encounters = repository.findAll();
        for (Encounter e : encounters) {
            if (Objects.equals(encounter.getWhen(), e.getWhen())
                    && Objects.equals(encounter.getType(), e.getType())
                    && Objects.equals(encounter.getDescription(), e.getDescription())) {
                result.addErrorMessage("duplicate encounter is not allowed");
                return result;
            }
        }

        encounter = repository.add(encounter);
        result.setPayload(encounter);
        return result;
    }

    private EncounterResult validate(Encounter encounter) {

        EncounterResult result = new EncounterResult();
        if (encounter == null) {
            result.addErrorMessage("encounter cannot be null");
            return result;
        }

        if (encounter.getWhen() == null || encounter.getWhen().trim().length() == 0) {
            result.addErrorMessage("when is required");
        }

        if (encounter.getDescription() == null || encounter.getDescription().trim().length() == 0) {
            result.addErrorMessage("description is required");
        }

        if (encounter.getOccurrences() <= 0) {
            result.addErrorMessage("occurrences must be greater than 0");
        }

        return result;
    }

    // Add the following Service Methods: findByType(), update(), deleteById()

    public List<Encounter> findByType(EncounterType type) throws DataAccessException{
        return repository.findByType(type);
    }

    public EncounterResult update(Encounter encounter) throws DataAccessException {
        EncounterResult result = validate(encounter);

        if(result.isSuccess()){
            if(repository.update(encounter)){
                result.setPayload(encounter);
            } else {
                result.addErrorMessage("Encounter ID " + encounter.getEncounterId() + " was not found.");
            }
        }
        return result;
    }

    public boolean deleteById(int id) throws DataAccessException{
        EncounterResult result = new EncounterResult();
        if(!repository.deleteById(id)){
            result.addErrorMessage("Encounter ID " + id + " not found.");
        } else {
            return true;
        }
        return false;
    }

    // update an encounter, searching via id
    public EncounterResult findById(int id) throws DataAccessException {
        EncounterResult result = new EncounterResult();
        Encounter encounter = repository.findById(id);
        if(encounter != null){
            result.setPayload(encounter);
        } else {
            result.addErrorMessage("Encounter with ID " + id + " does not exist.");
        }
        return result;
    }
}
