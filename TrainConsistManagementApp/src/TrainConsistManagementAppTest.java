import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    public boolean binarySearch(String[] arr, String key) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int result = arr[mid].compareTo(key);

            if (result == 0) return true;

            if (result < 0) low = mid + 1;
            else high = mid - 1;
        }

        return false;
    }

    @Test
    void testSearch_BogieFound() {

        String[] arr = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        Arrays.sort(arr);

        assertTrue(binarySearch(arr, "BG309"));
    }

    @Test
    void testSearch_BogieNotFound() {

        String[] arr = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        Arrays.sort(arr);

        assertFalse(binarySearch(arr, "BG999"));
    }

    @Test
    void testSearch_FirstElementMatch() {

        String[] arr = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        Arrays.sort(arr);

        assertTrue(binarySearch(arr, "BG101"));
    }

    @Test
    void testSearch_LastElementMatch() {

        String[] arr = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        Arrays.sort(arr);

        assertTrue(binarySearch(arr, "BG550"));
    }

    @Test
    void testSearch_SingleElementArray() {

        String[] arr = {"BG101"};

        assertTrue(binarySearch(arr, "BG101"));
    }
}