import java.sql.Connection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Connection connection = DatabaseConnection.getConnection();
        DuplicateChecker checker = new DuplicateChecker(connection);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add new value");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            if (choice == 1) {
                System.out.print("Enter value (email/username): ");
                String value = scanner.nextLine();

                if (checker.isDuplicate(value)) {
                    System.out.println(" Duplicate found!");
                } else {
                    checker.insertValue(value);
                    System.out.println(" Value added ");
                }
            } else {
                System.out.println("Program ended.");
                break;
            }
        }

        scanner.close();
    }
}
