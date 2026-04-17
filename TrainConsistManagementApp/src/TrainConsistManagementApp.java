public class TrainConsistManagementApp {

    public static void main(String[] args) {

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        String searchKey = "BG309";

        boolean found = linearSearch(bogieIds, searchKey);

        if (found) {
            System.out.println("Bogie ID " + searchKey + " FOUND in train consist.");
        } else {
            System.out.println("Bogie ID " + searchKey + " NOT FOUND in train consist.");
        }
    }

    // Linear Search Logic
    public static boolean linearSearch(String[] arr, String key) {

        for (String id : arr) {

            if (id.equals(key)) {
                return true; // early termination
            }
        }

        return false;
    }
}