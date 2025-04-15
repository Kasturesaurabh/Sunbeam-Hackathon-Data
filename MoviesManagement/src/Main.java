
import java.util.*;
import java.util.Scanner;

public class Main {
	Scanner sc = new Scanner(System.in);

	public void showMainMenu() {
		System.out.println("\n----MAIN MENU----");
		System.out.println("1. Sign Up");
		System.out.println("2. Sign In");
		System.out.println("3. Exit");
		System.out.println("Choose an Option: ");
		int ch = sc.nextInt();
		sc.nextLine();

		switch (ch) {

		case 1:
			SignUp();
			break;
		case 2:
			SignIn();
			break;
		case 3:
			System.out.println("Exiting..!");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid option. please Try again.");
		}
	}

	public void showSignedInMenu() {
		System.out.println("\n--- Signed-In Menu ---");
		System.out.println("1. Edit Profile");
		System.out.println("2. Change Password");
		System.out.println("3. Display All Movies");
		System.out.println("4. Create a Review");
		System.out.println("5. Edit Review");
		System.out.println("6. Delete Review");
		System.out.println("7. Display All Reviews");
		System.out.println("8. Display Reviews Shared with Me");
		System.out.println("9. Share Review");
		System.out.println("10. Sign Out");
		System.out.print("Choose an option: ");
		int ch = sc.nextInt();
		sc.nextLine();

		switch (ch) {
		case 1:
			editProfile();
			break;
		case 2:
			changePassword();
			break;
		case 3:
			displayAllMovies();
			break;
		case 4:
			createReview();
			break;
		case 5:
			editReview();
			break;
		case 6:
			deleteReview();
			break;
		case 7:
			displayAllReviews();
			break;
		case 8:
			displaySharedReviews();
			break;
		case 9:
			shareReview();
			break;
		case 10:
			signOut();
			break;
		default:
			System.out.println("Invalid choice. Please Try again.");
		}
	}


	static void SignUp() {
		System.out.println("SIGNUP ______");
	}

	static void SignUp() {
		System.out.println("ENTER USENAME: ");
		CUser = sc.nextLine();
		System.out.println("ENTER PASSWORD: ");
		CPassword = sc.nextInt();

	}

	static void signOut() {

	}

	static void editProfile() {
		System.out.println("Edit Profile");
	}

	static void changePassword() {
		System.out.println("Change Password");
	}

	static void displayAllMovies() {
		System.out.println("Display Movies");
	}

	static void createReview() {
		System.out.println("Create Review");
	}

	static void editReview() {
		System.out.println("Edit Review");
	}

	static void deleteReview() {
		System.out.println("Delete Review");
	}

	static void displayAllReviews() {
		System.out.println("All Reviews");
	}

	static void displaySharedReviews() {
		System.out.println("Shared Reviews");
	}

	static void shareReview() {
		System.out.println("Share Review");
	}

}
