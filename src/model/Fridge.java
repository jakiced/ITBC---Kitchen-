package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fridge {

    private Map<WeightedIngredient, Integer> weightedIngredientsMap = new HashMap<>();
    private List<Recipe> favouriteRecipes = new ArrayList<>();
    private static Fridge instance = null;

    private Fridge() {

    }

    public static Fridge getInstance() {
        if (instance == null) {
            instance = new Fridge();
        }
        return instance;
    }

    public Map<WeightedIngredient, Integer> getWeightedIngredientsMap() {
        return weightedIngredientsMap;
    }

    public void addWeightedIngredient(WeightedIngredient weightedIngredient) {
        Integer amount = this.weightedIngredientsMap.get(weightedIngredient);
        if (amount != null) {
            this.weightedIngredientsMap.put(weightedIngredient, amount + 1);
            System.out.println("You have just added " + weightedIngredient.getIngredientName() + " to the fridge");
        }
        else {
            this.weightedIngredientsMap.put(weightedIngredient, 1);
            System.out.println("You have just added " + weightedIngredient.getIngredientName() + " to the fridge");
        }
    }

    public void removeWeightedIngredient(WeightedIngredient weightedIngredient) {
        this.weightedIngredientsMap.remove(weightedIngredient);
    }

    public void reduceAmountOfWeightedIngredient(WeightedIngredient weightedIngredient, int weight) {
        Integer amount = this.weightedIngredientsMap.get(weightedIngredient);
        if (amount <= weight) {
            this.removeWeightedIngredient(weightedIngredient);
        }
        else {
            this.weightedIngredientsMap.put(weightedIngredient, amount - weight);
        }
    }

    public boolean canRecipeBeMade(Recipe recipe) {
        Map<WeightedIngredient, Integer> weightedIngredientsMapCopy = new HashMap<>(this.weightedIngredientsMap);
        for (WeightedIngredient recipeIngredient: recipe.getIngredients()) {
            if (weightedIngredientsMapCopy.get(recipeIngredient) == null) {
                return false;
            }
            weightedIngredientsMapCopy.put(recipeIngredient, weightedIngredientsMapCopy.get(recipeIngredient) - 1);
            if (weightedIngredientsMapCopy.get(recipeIngredient) < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean makeRecipe(Recipe recipe) {
        if (!this.canRecipeBeMade(recipe)) {
            return false;
        }
        for (WeightedIngredient recipeIngredient: recipe.getIngredients()) {
            this.weightedIngredientsMap.put(recipeIngredient, this.weightedIngredientsMap.get(recipeIngredient) - 1);
        }
        return true;
    }

    public void displayFavouriteRecipes() {
        System.out.println("Favourite recipes: ");
        for (Recipe recipe: this.favouriteRecipes) {
            System.out.println(recipe);
        }
    }

    public void displayFavouriteRecipes(double maxPrice) {
        System.out.println("Favourite recipes: ");
        for (Recipe recipe: this.favouriteRecipes) {
            if (recipe.getPrice() <= maxPrice) {
                System.out.println(recipe);
            }
        }
    }

    public void addFavouriteRecipe(Recipe recipe) {
        this.favouriteRecipes.add(recipe);
    }

    public void removeRecipeFromFavourites(Recipe recipe) {
        this.favouriteRecipes.remove(recipe);
    }

    @Override
    public String toString() {
        String weightedIngredientsForDisplay = "";
        for (Map.Entry<WeightedIngredient, Integer> entry: this.weightedIngredientsMap.entrySet()) {
            weightedIngredientsForDisplay += entry.getValue() + " " + entry.getKey().toString() + ", \n";
        }
        return weightedIngredientsForDisplay;
    }
}


