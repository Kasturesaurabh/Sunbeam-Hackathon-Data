import java.util.Scanner;

public class Main {
    private static AuthService authService = new AuthService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            if (authService.getCurrentUser() == null) {
                showLoginMenu();
            } else {
                showMainMenu();
            }
        }
    }

    private static void showLoginMenu() {
        System.out.println("\n=== Login System ===");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");

        int choice = getIntInput();

        switch (choice) {
            case 1:
                handleLogin();
                break;
            case 2:
                handleRegister();
                break;
            case 3:
                System.out.println("Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Try again.");
        }
    }

    private static void showMainMenu() {
        System.out.println("\n=== Welcome, " + authService.getCurrentUser().getUsername() + " ===");
        System.out.println("1. Do something");
        System.out.println("2. Logout");
        System.out.print("Choose an option: ");

        int choice = getIntInput();

        switch (choice) {
            case 1:
                System.out.println("Performing an action...");
                break;
            case 2:
                authService.logout();
                System.out.println("Logged out successfully.");
                break;
            default:
                System.out.println("Invalid option. Try again.");
        }
    }

    private static void handleLogin() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (authService.login(username, password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials. Try again.");
        }
    }

    private static void handleRegister() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (authService.register(username, password)) {
            System.out.println("Registration successful! You can now log in.");
        } else {
            System.out.println("Registration failed. Username may already exist.");
        }
    }

    private static int getIntInput() {
        try {
            String input = scanner.nextLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
