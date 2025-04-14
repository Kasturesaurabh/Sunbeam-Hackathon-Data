
import java.util.*;
import java.util.Scanner;

public class Main {
	Scanner sc = new Scanner(System.in);

}

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
	

}


