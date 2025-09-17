package learn.unexplained.data;

import learn.unexplained.models.Encounter;
import learn.unexplained.models.EncounterType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EncounterFileRepositoryTest {

    static final String TEST_PATH = "./data/encounters-test.csv";
    static final String SEED_PATH = "./data/encounters-seed.csv";
    final Encounter[] testEncounters = new Encounter[]{
            new Encounter(1, EncounterType.UFO, "2020-01-01", "short test #1", 1),
            new Encounter(2, EncounterType.CREATURE, "2020-02-01", "short test #2", 1),
            new Encounter(3, EncounterType.SOUND, "2020-03-01", "short test #3", 1)
    };

    EncounterRepository repository = new EncounterFileRepository(TEST_PATH);

    @BeforeEach
    void setup() throws DataAccessException {

        // copy lines from seed file to test file
        try(FileReader fileReader = new FileReader(SEED_PATH);
            BufferedReader reader = new BufferedReader(fileReader);
            PrintWriter writer = new PrintWriter(TEST_PATH)) {

            writer.println("encounter_id,type,when,description,occurrences"); // header
            for(String line = reader.readLine(); line != null; line = reader.readLine()){
                writer.println(line);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void shouldFindAll() throws DataAccessException {
        List<Encounter> encounters = repository.findAll();
        Encounter[] actual = encounters.toArray(new Encounter[encounters.size()]);
        assertArrayEquals(testEncounters, actual);
    }

    @Test
    void shouldAdd() throws DataAccessException {
        Encounter encounter = new Encounter();
        encounter.setType(EncounterType.UFO);
        encounter.setWhen("Jan 15, 2005");
        encounter.setDescription("moving pinpoint of light." +
                "seemed to move with me along the highway. " +
                "then suddenly reversed direction without slowing down. it just reversed.");
        encounter.setOccurrences(1);

        Encounter actual = repository.add(encounter);

        assertNotNull(actual);
        assertEquals(4, actual.getEncounterId());
    }

    @Test
    void findBytype() throws DataAccessException {
        // getting correct items
        List<Encounter> actual = repository.findByType(EncounterType.UFO);
        assertEquals(1, actual.size());
        assertEquals(testEncounters[0], actual.get(0));
        actual = repository.findByType(EncounterType.CREATURE);
        assertEquals(1, actual.size());
        assertEquals(testEncounters[1], actual.get(0));
        actual = repository.findByType(EncounterType.SOUND);
        assertEquals(1, actual.size());
        assertEquals(testEncounters[2], actual.get(0));

        actual = repository.findByType(EncounterType.VOICE);
        assertTrue(actual.isEmpty());
    }

    @Test
    void update() throws DataAccessException {
        Encounter newEncounter = new Encounter(999, EncounterType.VOICE, "2025-09-17", "update test", 7);
        assertFalse(repository.update(newEncounter));
        newEncounter.setEncounterId(2);
        assertTrue(repository.update(newEncounter));

        List<Encounter> all = repository.findAll();
        assertEquals(newEncounter, all.get(1));
    }

    @Test
    void deleteById() throws DataAccessException{
        assertFalse(repository.deleteById(999));
        List<Encounter> all = repository.findAll();
        assertEquals(3, all.size());
        assertTrue(repository.deleteById(2));
        all = repository.findAll();
        assertEquals(2, all.size());
    }

}