import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    private List<Bogie> getSampleBogies() {
        return Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 40),
                new Bogie("Sleeper", 80)
        );
    }

    private List<Bogie> loopFilter(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                result.add(b);
            }
        }
        return result;
    }

    private List<Bogie> streamFilter(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> result = loopFilter(getSampleBogies());
        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 60));
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> result = streamFilter(getSampleBogies());
        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 60));
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> loopResult = loopFilter(getSampleBogies());
        List<Bogie> streamResult = streamFilter(getSampleBogies());

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> list = getSampleBogies();

        long start = System.nanoTime();
        streamFilter(list);
        long end = System.nanoTime();

        long duration = end - start;

        assertTrue(duration > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> largeList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            largeList.add(new Bogie("Sleeper", (i % 100) + 30));
        }

        List<Bogie> result = streamFilter(largeList);

        assertNotNull(result);
        assertTrue(result.size() > 0);
    }
}