import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    public boolean searchBogie(String[] bogies, String key) {

        if (bogies == null || bogies.length == 0) {
            throw new IllegalStateException("Train consist is empty. Search operation not allowed.");
        }

        for (String id : bogies) {
            if (id.equals(key)) {
                return true;
            }
        }

        return false;
    }

    @Test
    void testSearch_EmptyTrainThrowsException() {

        String[] bogies = {};

        Exception ex = assertThrows(IllegalStateException.class, () -> {
            searchBogie(bogies, "BG101");
        });

        assertEquals("Train consist is empty. Search operation not allowed.", ex.getMessage());
    }

    @Test
    void testSearch_NonEmptyTrainWorks() {

        String[] bogies = {"BG101", "BG205", "BG309"};

        assertTrue(searchBogie(bogies, "BG205"));
    }

    @Test
    void testSearch_NotFound() {

        String[] bogies = {"BG101", "BG205", "BG309"};

        assertFalse(searchBogie(bogies, "BG999"));
    }
}