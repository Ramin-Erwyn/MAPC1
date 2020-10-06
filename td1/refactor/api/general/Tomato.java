package td1.refactor.api.general;

import td1.refactory.api.general.FoodProduct;

public class Tomato implements FoodProduct {

    private double weight;
    private double BASE_PRICE = 0.5;

    public Tomato(double weight) {
        this.weight = weight;
    }

    public double caloriesPer100grams() {
        return 21;
    }

    public double calories() {
        return this.caloriesPer100grams() * this.weight() / 100;
    }

    public double weight() {
        return weight;
    }

    public double price() {
        return BASE_PRICE * weight / 100;
    }

    public String toString() {
        return String.format("tomato, qty: %.0f -- %.2f", weight(), price());
    }
}
