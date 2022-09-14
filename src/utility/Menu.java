package utility;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static int getMenu(Scanner scanner) {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Welcome to Hell's Kitchen. Choose an option or press 0 to run!");
        System.out.println();
        System.out.println("1. Add an ingredient to the fridge");
        System.out.println("2. Show content of the fridge");
        System.out.println("3. Reduce amount of ingredient");
        System.out.println("4. Remove a whole ingredient");
        System.out.println("5. Make a meal");
        System.out.println("6. List recipes by maximum price");
        System.out.println("7. List recipes by difficulty");
        System.out.println("8. List recipes by difficulty and maximum price");
        System.out.println("9. Sort recipes by difficulty, beginner to pro");
        System.out.println("10. Sort recipes by price (ascending)");
        System.out.println("11. See favourite recipes");
        System.out.println("12. Add a favourite recipe");
        System.out.println("13. Remove recipe from favourites");
        System.out.println("14. See favourite recipes with maximum given price");
        System.out.println("15. Display all ingredients from the database");
        System.out.println("16. Display all recipes from the database");

        try {
            int option = scanner.nextInt();
            scanner.nextLine();
            return option;
        } catch (InputMismatchException e) {
            System.out.println("Input must be a number. Exiting application");
            return 0;
        }
    }
}
