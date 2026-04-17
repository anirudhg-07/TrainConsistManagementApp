import java.util.Arrays;

public class TrainConsistManagementApp {

        int n = arr.length;

        String[] bogieNames = {
                "Sleeper",
                "AC Chair",
                "First Class",
                "General",
                "Luxury"
        };

        System.out.println("Original Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));

        // UC17: Built-in sorting
        Arrays.sort(bogieNames);

        System.out.println("\nSorted Bogie Names (Alphabetical):");
        System.out.println(Arrays.toString(bogieNames));
    }
}