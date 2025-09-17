package learn.memories.data;

import learn.memories.models.Memory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MemoryFileRepositoryTest {

    static final String SEED_FINAL_PATH = "./data/memories-seed.txt";
    static final String TEST_FILE_PATH = "./data/memories-test.txt";

    MemoryFileRepository repository = new MemoryFileRepository(TEST_FILE_PATH);
    Memory uncleSherwin;

    @BeforeEach
    void setupTest() throws IOException{
        Path seedPath = Paths.get(SEED_FINAL_PATH);
        Path testPath = Paths.get(TEST_FILE_PATH);
        Files.copy(seedPath, testPath, StandardCopyOption.REPLACE_EXISTING);

        uncleSherwin = new Memory();
        uncleSherwin.setId(2);
        uncleSherwin.setFrom("Uncle Sherwin");
        uncleSherwin.setContent("When you were two, you burned your finger and said you had an \"owie minger\". So cute.");
        uncleSherwin.setShareable(true);
    }

    @Test
    void findall() throws DataAccessException{
        List<Memory> actual = repository.findAll();
        assertEquals(3, actual.size());
    }

    @Test
    void findShareable() throws DataAccessException{
        List<Memory> actual = repository.findShareable(true);
        assertEquals(2, actual.size());

        actual = repository.findShareable(false);
        assertEquals(1, actual.size());
    }

    @Test
    void findById() throws DataAccessException{
        Memory actual = repository.findById(2);
        assertNotNull(actual);
        assertEquals(uncleSherwin.getFrom(), actual.getFrom());
        assertTrue(actual.isShareable());

        actual = repository.findById(9999);
        assertNull(actual);
    }

    @Test
    void add() throws DataAccessException{
        Memory memory = new Memory();
        memory.setFrom("A Friend");
        memory.setContent("A Special Memory");
        Memory actual = repository.add(memory);
        assertEquals(4, actual.getId());

        List<Memory> all = repository.findAll();
        assertEquals(4, all.size());

        actual = all.get(3);
        assertEquals(4, actual.getId());
        assertEquals("A Friend", actual.getFrom());
        assertEquals("A Special Memory", actual.getContent());
        assertFalse(actual.isShareable());
    }

    @Test
    void update() throws DataAccessException{
        Memory memory = repository.findById(2);
        memory.setFrom("Sherwin");
        memory.setShareable(false);
        assertTrue(repository.update(memory));

        memory = repository.findById(2);
        assertNotNull(memory);

        assertEquals("Sherwin", memory.getFrom());
        assertFalse(memory.isShareable());

        Memory notExists = new Memory();
        notExists.setId(9999);
        notExists.setFrom("Test");
        notExists.setContent("Test");
        notExists.setShareable(true);

        assertFalse(repository.update(notExists));
    }

    @Test
    void deleteById() throws DataAccessException{
        int count = repository.findAll().size();
        assertTrue(repository.deleteById(1));
        assertFalse(repository.deleteById(9999));
        assertEquals(count - 1, repository.findAll().size());
    }

}
