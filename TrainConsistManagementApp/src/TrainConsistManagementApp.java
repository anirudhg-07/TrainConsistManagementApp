class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

class GoodsBogie {
    String type;
    String cargo;

    public GoodsBogie(String type) {
        this.type = type;
    }

    public void assignCargo(String cargo) {
        System.out.println("\nAssigning cargo: " + cargo + " to " + type + " bogie");

        try {
            if (type.equalsIgnoreCase("Rectangular") &&
                    cargo.equalsIgnoreCase("Petroleum")) {

                throw new CargoSafetyException(
                        "Unsafe Assignment: Petroleum cannot be assigned to Rectangular bogie"
                );
            }

            this.cargo = cargo;
            System.out.println("Cargo assigned successfully.");

        } catch (CargoSafetyException e) {
            System.out.println("Exception Occurred: " + e.getMessage());
            System.out.println("Cargo assignment failed.");
            this.cargo = null;

        } finally {
            System.out.println("Validation completed for " + type + " bogie.");
        }
    }

    public String toString() {
        return "Bogie Type: " + type + ", Cargo: " + cargo;
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        GoodsBogie b2 = new GoodsBogie("Rectangular");

        // Safe assignment
        b1.assignCargo("Petroleum");

        // Unsafe assignment
        b2.assignCargo("Petroleum");

        System.out.println("\n=== FINAL STATE ===");
        System.out.println(b1);
        System.out.println(b2);

        System.out.println("\nProgram Continues Safely...");
    }
}