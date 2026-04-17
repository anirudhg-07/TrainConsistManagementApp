import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class Bogie {
    String type;
    int capacity;

    public Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}

public class TrainConsistManagementAppTest {

    private List<Bogie> getSampleBogies() {
        return Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 40),
                new Bogie("Sleeper", 80),
                new Bogie("AC Chair", 70)
        );
    }

    // UC8 Filter Logic
    private List<Bogie> filterBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> result = filterBogies(getSampleBogies(), 70);

        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 70));
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> result = filterBogies(getSampleBogies(), 70);

        assertFalse(result.stream().anyMatch(b -> b.getCapacity() == 70));
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> result = filterBogies(getSampleBogies(), 70);

        assertFalse(result.stream().anyMatch(b -> b.getCapacity() < 70));
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> result = filterBogies(getSampleBogies(), 60);

        assertEquals(3, result.size()); // 72, 80, 70
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> result = filterBogies(getSampleBogies(), 100);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> result = filterBogies(getSampleBogies(), 30);

        assertEquals(getSampleBogies().size(), result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> result = filterBogies(new ArrayList<>(), 60);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> original = new ArrayList<>(getSampleBogies());
        List<Bogie> copy = new ArrayList<>(original);

        filterBogies(original, 60);

        assertEquals(copy.size(), original.size());
        for (int i = 0; i < original.size(); i++) {
            assertEquals(copy.get(i).getCapacity(), original.get(i).getCapacity());
        }
    }
}