package td1.refactor.api.general;

import td1.refactory.api.general.FoodProduct;

public class DeepFriedOnions implements FoodProduct {


    private double weight;
    private double BASE_PRICE = 1.5;

    public DeepFriedOnions(double weight) {
        this.weight = weight;
    }

    public double caloriesPer100grams() {
        return 590;
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
        return String.format("deep fried onions (%.0fg) -- %.2f€", weight(), price());
    }

}
