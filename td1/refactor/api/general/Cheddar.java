package td1.refactor.api.general;

import td1.refactory.api.general.FoodProduct;

public class Cheddar implements FoodProduct {
    // 400 kcal / 100g

    private double weight;
    private double BASE_PRICE = 4;

    public Cheddar(double weight) {
        this.weight = weight;
    }

     // @Override
    public double caloriesPer100grams() {
        return 400;
    }

    // @Override
    public double calories() {
        return this.caloriesPer100grams() * this.weight() / 100;
    }

    // @Override
    public double weight() {
        return weight;
    }

    // @Override
    public double price() {
        return BASE_PRICE * weight / 100;
    }

    // @Override
    public String toString() {
        return String.format("cheddar (%.0fg) -- %.2f€", weight(), price());
    }
}
