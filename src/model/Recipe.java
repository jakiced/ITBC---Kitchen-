package model;

import enums.RecipeDifficulty;
import interfaces.IPriceable;
import utility.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Recipe implements IPriceable {

    private String recipeName;
    private RecipeDifficulty difficulty;
    private List<WeightedIngredient> ingredients = new ArrayList<>();

    public Recipe(String recipeName, RecipeDifficulty difficulty) {
        this.recipeName = recipeName;
        this.difficulty = difficulty;
    }

    public Recipe(Recipe recipe) {
        this.recipeName = recipe.getRecipeName();
        this.difficulty = recipe.getDifficulty();
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public RecipeDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(RecipeDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public List<WeightedIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<WeightedIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public double getPrice() {
        double sum = 0;
        for(WeightedIngredient weightedIngredient: this.ingredients) {
            sum += weightedIngredient.getPrice();
        }
        return sum;
    }

    public void addWeightedIngredients(WeightedIngredient weightedIngredient) {
        this.ingredients.add(weightedIngredient);
    }

    public void removeWeightedIngredient(WeightedIngredient weightedIngredient) {
        this.ingredients.removeIf(ingredient -> Objects.equals(ingredient.id, weightedIngredient.id));
    }

    public Recipe getScaledRecipe(double percentage) {
        Recipe scaledRecipe = new Recipe(this.recipeName, this.difficulty);
        List<WeightedIngredient> scaledIngredients = new ArrayList<>();
        for(WeightedIngredient weightedIngredient: this.ingredients) {
            WeightedIngredient scaledIngredient = new WeightedIngredient(weightedIngredient.getId(), weightedIngredient.getIngredientName(),
                    weightedIngredient.getWeight() / (percentage * 0.01), weightedIngredient.getPricePerUnit());
        }
        scaledRecipe.setIngredients(scaledIngredients);
        return scaledRecipe;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        return Objects.equals(this.recipeName, ((Recipe) obj).recipeName);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeName='" + recipeName + '\'' +
                ", difficulty=" + difficulty +
                ", price=" + this.getPrice() +
                '}';
    }
}
