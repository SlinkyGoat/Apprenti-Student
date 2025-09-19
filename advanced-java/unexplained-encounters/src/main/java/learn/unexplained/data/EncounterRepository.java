package learn.unexplained.data;

import learn.unexplained.models.Encounter;
import learn.unexplained.models.EncounterType;

import java.util.List;

public interface EncounterRepository {
    List<Encounter> findAll() throws DataAccessException;

    Encounter add(Encounter encounter) throws DataAccessException;

    boolean deleteById(int encounterId) throws DataAccessException;

    // Add two new repository methods
    List<Encounter> findByType(EncounterType type) throws DataAccessException;

    boolean update(Encounter newEncounter) throws  DataAccessException;

    Encounter findById(int id) throws DataAccessException;
}
