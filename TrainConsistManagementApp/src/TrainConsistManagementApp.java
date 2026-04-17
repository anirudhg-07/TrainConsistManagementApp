public class TrainConsistManagementApp {

    public static void main(String[] args) {

        String[] bogieIds = {}; // empty train

        String searchKey = "BG101";

        try {
            boolean result = searchBogie(bogieIds, searchKey);

            if (result) {
                System.out.println("Bogie ID " + searchKey + " FOUND in train consist.");
            } else {
                System.out.println("Bogie ID " + searchKey + " NOT FOUND in train consist.");
            }

        } catch (IllegalStateException e) {
            System.out.println("Exception Occurred: " + e.getMessage());
        }

        System.out.println("Program continues safely...");
    }

    // Search method with fail-fast validation
    public static boolean searchBogie(String[] bogies, String key) {

        // UC20: Defensive check
        if (bogies == null || bogies.length == 0) {
            throw new IllegalStateException("Train consist is empty. Search operation not allowed.");
        }

        // simple linear search (can be UC18/UC19 integrated)
        for (String id : bogies) {
            if (id.equals(key)) {
                return true;
            }
        }

        return false;
    }
}