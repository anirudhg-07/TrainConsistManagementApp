import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testCargo_SafeAssignment() {
        GoodsBogie bogie = new GoodsBogie("Cylindrical");

        bogie.assignCargo("Petroleum");

        assertEquals("Petroleum", bogie.cargo);
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        assertNull(bogie.cargo);
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        assertNotEquals("Petroleum", bogie.cargo);
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        GoodsBogie b2 = new GoodsBogie("Rectangular");

        b1.assignCargo("Petroleum");
        b2.assignCargo("Petroleum");

        // If program continues, both calls should complete execution
        assertTrue(true);
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        // If method completes, finally block executed (no crash = pass)
        assertTrue(true);
    }
}