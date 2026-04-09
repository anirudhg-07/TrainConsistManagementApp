import java.util.LinkedList;

public class TrainConsistManagementApp{
    public static void main(String[] args) {

        // Step 1: Create LinkedList for train consist
        LinkedList<String> train = new LinkedList<>();

        // Step 2: Add bogies in order
        train.add("Engine");
        train.add("Sleeper");
        train.add("AC");
        train.add("Cargo");
        train.add("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(train);

        // Step 3: Insert Pantry Car at position 2 (index starts from 0)
        train.add(2, "Pantry");

        System.out.println("\nAfter adding Pantry Car at position 2:");
        System.out.println(train);

        // Step 4: Remove first and last bogie
        train.removeFirst();
        train.removeLast();

        System.out.println("\nAfter removing first and last bogie:");
        System.out.println(train);

        // Step 5: Display final train consist
        System.out.println("\nFinal Ordered Train Consist:");
        for (String bogie : train) {
            System.out.println(bogie);
        }
    }
}