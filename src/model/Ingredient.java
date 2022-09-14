package model;

import interfaces.IPriceable;

public abstract class Ingredient implements IPriceable {

    protected Long id;
    protected String ingredientName;

    public Ingredient(Long id, String ingredientName) {
        this.id = id;
        this.ingredientName = ingredientName;
    }

    public Ingredient(Ingredient ingredient) {
        this.id = ingredient.getId();
        this.ingredientName = ingredient.getIngredientName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

}
