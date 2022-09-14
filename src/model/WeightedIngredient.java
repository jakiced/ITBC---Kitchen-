package model;

import utility.PriceLogger;

import java.util.Objects;

public class WeightedIngredient extends Ingredient{

    private double weight;
    private double pricePerUnit;

    public WeightedIngredient(Long id, String ingredientName, double weight, double pricePerUnit) {
        super(id, ingredientName);
        this.weight = weight;
        this.pricePerUnit = pricePerUnit;
    }

    public WeightedIngredient(WeightedIngredient ingredient) {
        super(ingredient);
        this.weight = ingredient.getWeight();
        this.pricePerUnit = ingredient.getPricePerUnit();
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public double getPrice() {
        return this.pricePerUnit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        return Objects.equals(id, ((WeightedIngredient) obj).id);
    }

    public void displayPrice() {
        PriceLogger.displayPrice(this);
    }

    @Override
    public String toString() {
        return "WeightedIngredient {" +
                "name=" + ingredientName +
                ", weight=" + weight +
                ", price per unit='" + pricePerUnit + '\'' +
                '}';
    }
}
