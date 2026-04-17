import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(TrainConsistManagementApp.validateTrainId("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(TrainConsistManagementApp.validateTrainId("TRAIN12"));
        assertFalse(TrainConsistManagementApp.validateTrainId("TRN12A"));
        assertFalse(TrainConsistManagementApp.validateTrainId("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(TrainConsistManagementApp.validateCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(TrainConsistManagementApp.validateCargoCode("PET-ab"));
        assertFalse(TrainConsistManagementApp.validateCargoCode("PET123"));
        assertFalse(TrainConsistManagementApp.validateCargoCode("AB-PET"));
    }
}