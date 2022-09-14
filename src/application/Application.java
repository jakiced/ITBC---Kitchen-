package application;

import enums.RecipeDifficulty;
import model.Fridge;
import model.Recipe;
import utility.Database;
import utility.Menu;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int option;
        do {
            option = Menu.getMenu(scanner);
            switch (option) {
                case 1:
                    System.out.println("Enter the id of ingredient");
                    Database.getInstance().displayIngredients();
                    Long id = scanner.nextLong();
                    Fridge.getInstance().addWeightedIngredient(Database.getInstance().findIngredientById(id));
                    break;
                case 2:
                    System.out.println(Fridge.getInstance());
                    break;
                case 3:
                    System.out.println("Enter ingredient id: ");
                    id = scanner.nextLong();
                    System.out.println("Enter the amount: ");
                    int amount = scanner.nextInt();
                    Fridge.getInstance().reduceAmountOfWeightedIngredient(Database.getInstance().getWeightedIngredientsDB()
                            .get((int) (id - 1)), amount);
                    break;
                case 4:
                    System.out.println("Enter the ingredient id: ");
                    id = scanner.nextLong();
                    Fridge.getInstance().removeWeightedIngredient(Database.getInstance().getWeightedIngredientsDB().get((int) (id -1)));
                    break;
                case 5:
                    System.out.println("Enter recipe name: ");
                    String name = scanner.nextLine();
                    Fridge.getInstance().makeRecipe(Database.getInstance().findRecipeByName(name));
                    break;
                case 6:
                    System.out.println("Enter max price: ");
                    Double maxPrice = scanner.nextDouble();
                    Database.getInstance().getRecipesByMaxPrice(maxPrice);
                    break;
                case 7:
                    System.out.println("Enter recipe difficulty: 0 - beginner, 1 - easy, 2 - medium," +
                            "3 - hard, 4 - pro");
                    int index = scanner.nextInt();
                    Database.getInstance().getRecipesByDifficulty(RecipeDifficulty.values()[index]);
                    break;
                case 8:
                    System.out.println("Enter recipe difficulty: 0 - beginner, 1 - easy, 2 - medium," +
                            "3 - hard, 4 - pro");
                    index = scanner.nextInt();
                    System.out.println("Enter max price: ");
                    maxPrice = scanner.nextDouble();
                    Database.getInstance().getRecipesByDifficultyAndMaxPrice(RecipeDifficulty.values()[index], maxPrice);
                    break;
                case 9:
                    Database.getInstance().sortByDifficulty();
                    break;
                case 10:
                    Database.getInstance().sortByPrice();
                    break;
                case 11:
                    Fridge.getInstance().displayFavouriteRecipes();
                    break;
                case 12:
                    System.out.println("Enter recipe name: ");
                    Database.getInstance().displayRecipes();
                    name = scanner.nextLine();
                    Recipe recipe = Database.getInstance().findRecipeByName(name);
                    System.out.println(recipe);
                    Fridge.getInstance().addFavouriteRecipe(recipe);
                    break;
                case 13:
                    System.out.println("Enter recipe name: ");
                    name = scanner.next();
                    recipe = Database.getInstance().findRecipeByName(name);
                    System.out.println(recipe);
                    Fridge.getInstance().removeRecipeFromFavourites(recipe);
                    break;
                case 14:
                    System.out.println("Enter max price: ");
                    maxPrice = scanner.nextDouble();
                    Fridge.getInstance().displayFavouriteRecipes(maxPrice);
                    break;
                case 15:
                    Database.getInstance().displayIngredients();
                    break;
                case 16:
                    Database.getInstance().displayRecipes();
                    break;
                default:
                    break;

            }
        } while (option != 0);
        scanner.close();
    }
}
