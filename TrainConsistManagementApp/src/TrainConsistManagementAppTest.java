import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    private int calculateTotalSeats(List<Bogie> bogies) {
        return bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
    }

    private List<Bogie> getSampleBogies() {
        return Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 60),
                new Bogie("Sleeper", 80),
                new Bogie("First Class", 40)
        );
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        int total = calculateTotalSeats(getSampleBogies());
        assertEquals(252, total); // 72 + 60 + 80 + 40
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        int total = calculateTotalSeats(getSampleBogies());
        assertTrue(total > 0);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> list = Collections.singletonList(new Bogie("Sleeper", 70));
        int total = calculateTotalSeats(list);

        assertEquals(70, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        int total = calculateTotalSeats(new ArrayList<>());
        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> list = getSampleBogies();
        int total = calculateTotalSeats(list);

        int expected = 0;
        for (Bogie b : list) {
            expected += b.getCapacity();
        }

        assertEquals(expected, total);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> list = getSampleBogies();
        int total = calculateTotalSeats(list);

        assertEquals(252, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> original = new ArrayList<>(getSampleBogies());
        List<Bogie> copy = new ArrayList<>(original);

        calculateTotalSeats(original);

        assertEquals(copy.size(), original.size());
    }
}