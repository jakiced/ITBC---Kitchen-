package utility;

import enums.RecipeDifficulty;
import model.Recipe;
import model.WeightedIngredient;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database {

    private List<WeightedIngredient> weightedIngredientsDB;
    private List<Recipe> recipes;
    private static Database instance = null;

    private Database() {
        WeightedIngredient sourCream = new WeightedIngredient(1L, "Sour Cream", 1.0, 2.2);
        WeightedIngredient chocolate = new WeightedIngredient(2L, "Chocolate", 2.0, 3.2);
        WeightedIngredient eggs = new WeightedIngredient(3L, "Eggs", 6, 4);
        WeightedIngredient flour = new WeightedIngredient(4L, "Flour", 2.0, 0.5);
        WeightedIngredient sugar = new WeightedIngredient(5L, "Sugar", 2.0, 1.2);
        WeightedIngredient salt = new WeightedIngredient(6L, "Salt", 1.0, 2.2);
        WeightedIngredient blackPepper = new WeightedIngredient(7L, "Black Pepper", 0.2, 5.1);
        WeightedIngredient paprika = new WeightedIngredient(8L, "Paprika", 5.0, 5.2);
        WeightedIngredient milk = new WeightedIngredient(9L, "Milk", 1.0, 10);
        WeightedIngredient yeast = new WeightedIngredient(10L, "Yeast", 0.4, 1.3);
        WeightedIngredient sunflowerOil = new WeightedIngredient(11L,"Sunflower Oil", 1.0, 6.4);
        WeightedIngredient vinegar = new WeightedIngredient(12L,"Vinegar", 1.0, 7.2);
        WeightedIngredient butter = new WeightedIngredient(13L, "Butter", 1.0, 3.1);
        WeightedIngredient garlic = new WeightedIngredient(14L, "Garlic", 1.0, 4.5);
        WeightedIngredient onion = new WeightedIngredient(15L,"Onions", 1.0, 3.2);
        WeightedIngredient mushrooms = new WeightedIngredient(16L, "Mushrooms", 3.0, 11.1);
        WeightedIngredient lemon = new WeightedIngredient(17L, "Lemon", 2.0, 4.7);
        WeightedIngredient chicken = new WeightedIngredient(18L, "Chicken Breasts", 5.0, 12.3);
        WeightedIngredient coffee = new WeightedIngredient(19L, "Coffee", 2.0, 4.2);
        WeightedIngredient water = new WeightedIngredient(20L, "Water", 5.0, 0.9);
        WeightedIngredient beef = new WeightedIngredient(21L, "Beef", 5.0, 14.5);
        WeightedIngredient bacon = new WeightedIngredient(22L, "Bacon", 2.0, 9.1);
        WeightedIngredient potato = new WeightedIngredient(23L, "Potato", 5.0, 2.4);
        WeightedIngredient fish = new WeightedIngredient(24L, "Fish", 2.1, 7.8);
        WeightedIngredient cheese = new WeightedIngredient(25L, "Cheese", 1.1, 9.7);

        this.weightedIngredientsDB = Arrays.asList(sourCream, chocolate, eggs, flour, sugar, salt, blackPepper,paprika,
                milk, yeast, sunflowerOil, vinegar, butter, garlic, onion, mushrooms, lemon, chicken, coffee, water, beef,
                bacon, potato, fish, cheese);



        Recipe pancakes = new Recipe("Pancakes", RecipeDifficulty.BEGINNER);
        pancakes.addWeightedIngredients(eggs);
        pancakes.addWeightedIngredients(flour);
        pancakes.addWeightedIngredients(milk);

        Recipe donuts = new Recipe("Donuts", RecipeDifficulty.EASY);
        donuts.addWeightedIngredients(eggs);
        donuts.addWeightedIngredients(yeast);
        donuts.addWeightedIngredients(milk);
        donuts.addWeightedIngredients(flour);

        Recipe chickenWithMushroomsInBaconSpicyCream = new Recipe("Chicken with mushrooms in bacon spicy cream", RecipeDifficulty.HARD);
        chickenWithMushroomsInBaconSpicyCream.addWeightedIngredients(bacon);
        chickenWithMushroomsInBaconSpicyCream.addWeightedIngredients(chicken);
        chickenWithMushroomsInBaconSpicyCream.addWeightedIngredients(mushrooms);
        chickenWithMushroomsInBaconSpicyCream.addWeightedIngredients(onion);
        chickenWithMushroomsInBaconSpicyCream.addWeightedIngredients(sunflowerOil);
        chickenWithMushroomsInBaconSpicyCream.addWeightedIngredients(paprika);
        chickenWithMushroomsInBaconSpicyCream.addWeightedIngredients(blackPepper);
        chickenWithMushroomsInBaconSpicyCream.addWeightedIngredients(salt);
        chickenWithMushroomsInBaconSpicyCream.addWeightedIngredients(sourCream);

        Recipe baconWithEggs = new Recipe("Bacon with Eggs", RecipeDifficulty.MEDIUM);
        baconWithEggs.addWeightedIngredients(bacon);
        baconWithEggs.addWeightedIngredients(eggs);
        baconWithEggs.addWeightedIngredients(sunflowerOil);
        baconWithEggs.addWeightedIngredients(salt);

        Recipe fishAndChips = new Recipe("Fish and Chips", RecipeDifficulty.EASY);
        fishAndChips.addWeightedIngredients(fish);
        fishAndChips.addWeightedIngredients(potato);
        fishAndChips.addWeightedIngredients(sunflowerOil);

        Recipe birthdayCake = new Recipe("Birthday Cake", RecipeDifficulty.PRO);
        birthdayCake.addWeightedIngredients(sourCream);
        birthdayCake.addWeightedIngredients(chocolate);
        birthdayCake.addWeightedIngredients(eggs);
        birthdayCake.addWeightedIngredients(flour);
        birthdayCake.addWeightedIngredients(sugar);
        birthdayCake.addWeightedIngredients(milk);
        birthdayCake.addWeightedIngredients(butter);
        birthdayCake.addWeightedIngredients(lemon);
        birthdayCake.addWeightedIngredients(coffee);

        Recipe bread = new Recipe("Bread", RecipeDifficulty.BEGINNER);
        bread.addWeightedIngredients(flour);
        bread.addWeightedIngredients(water);

        Recipe pizza = new Recipe("Pizza", RecipeDifficulty.MEDIUM);
        pizza.addWeightedIngredients(flour);
        pizza.addWeightedIngredients(yeast);
        pizza.addWeightedIngredients(bacon);
        pizza.addWeightedIngredients(cheese);

        Recipe pepperInSourCream = new Recipe("Pepper in Sour Cream", RecipeDifficulty.EASY);
        pepperInSourCream.addWeightedIngredients(sourCream);
        pepperInSourCream.addWeightedIngredients(paprika);
        pepperInSourCream.addWeightedIngredients(sunflowerOil);
        pepperInSourCream.addWeightedIngredients(garlic);

        Recipe pudding = new Recipe("Pudding", RecipeDifficulty.MEDIUM);
        pudding.addWeightedIngredients(chocolate);
        pudding.addWeightedIngredients(milk);
        pudding.addWeightedIngredients(sugar);

        this.recipes = Arrays.asList(pancakes, donuts, chickenWithMushroomsInBaconSpicyCream, baconWithEggs,
                fishAndChips, birthdayCake, bread, pizza, pepperInSourCream, pudding);
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public List<WeightedIngredient> getWeightedIngredientsDB() {
        return weightedIngredientsDB;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public WeightedIngredient findIngredientById(Long id) {
        for (WeightedIngredient weightedIngredient: Database.getInstance().getWeightedIngredientsDB()) {
            if (weightedIngredient.getId() == id) {
                return weightedIngredient;
            }
        }
        return null;
    }

    public Recipe findRecipeByName(String name) {
        for (Recipe recipe: Database.getInstance().getRecipes()) {
            if (recipe.getRecipeName().equals(name)) {
                return recipe;
            }
        }
        return null;
    }

    public List<Recipe> getRecipesByDifficulty(RecipeDifficulty difficulty) {
        List<Recipe> result = new ArrayList<>();
        for(Recipe recipe: Database.getInstance().getRecipes()) {
            if (recipe.getDifficulty() == difficulty) {
                System.out.println(recipe);
                result.add(recipe);
            }
        }
        return result;
    }

    public List<Recipe> getRecipesByMaxPrice(double price) {
        List<Recipe> result = new ArrayList<>();
        for (Recipe recipe: Database.getInstance().getRecipes()) {
            if (recipe.getPrice() <= price) {
                System.out.println(recipe);
                result.add(recipe);
            }
        }
        return result;
    }

    public List<Recipe> getRecipesByDifficultyAndMaxPrice(RecipeDifficulty difficulty, double price) {
        List<Recipe> result = new ArrayList<>();
        for (Recipe recipe: Database.getInstance().getRecipes()) {
            if(recipe.getPrice() <= price && recipe.getDifficulty() == difficulty) {
                System.out.println(recipe);
                result.add(recipe);
            }
        }
        return result;
    }

    public void sortByDifficulty(){
        Database.getInstance().getRecipes().sort((recipe1, recipe2) -> recipe1.getDifficulty().compareTo(recipe2.getDifficulty()));
        for(Recipe recipe: Database.getInstance().getRecipes()){
            System.out.println(recipe.getRecipeName());
        }
    }

    public void sortByPrice(){
        Database.getInstance().getRecipes().sort((recipe1, recipe2) -> (int) (recipe1.getPrice() - recipe2.getPrice()));
        for(Recipe recipe: Database.getInstance().getRecipes()){
            System.out.println(recipe.getRecipeName() + " " + recipe.getPrice());
        }
    }

    public void displayIngredients() {
        for (WeightedIngredient weightedIngredient: weightedIngredientsDB) {
            System.out.println(weightedIngredient.getId() + " " + weightedIngredient.getIngredientName());
        }
    }

    public void displayRecipes() {
        for (Recipe recipe: recipes) {
            System.out.println(recipe);
        }
    }
}
