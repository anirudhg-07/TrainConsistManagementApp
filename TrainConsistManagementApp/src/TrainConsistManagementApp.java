class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

class PassengerBogie {
    String type;
    int capacity;

    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return type + " Bogie -> Capacity: " + capacity;
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        try {
            PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
            PassengerBogie b2 = new PassengerBogie("AC Chair", 0);   // invalid
            PassengerBogie b3 = new PassengerBogie("First Class", 50);

            System.out.println(b1);
            System.out.println(b2);
            System.out.println(b3);

        } catch (InvalidCapacityException e) {
            System.out.println("Exception Occurred: " + e.getMessage());
        }

        System.out.println("\nProgram Continues Safely...");
    }
}