package td1.refactor.api.general;

import td1.refactory.api.general.FoodProduct;

public class Sauce implements FoodProduct {

    public enum SauceType {
        BURGER, BARBECUE, BEARNAISE;

       public double  caloriesPer100Grams() {
           double calorie = 0.0;
           if (this == BURGER) return 240;
           if (this == BARBECUE) return 130;
           if (this == BEARNAISE) return 550;
           else return calorie;

       }
    }

    private static double BASE_PRICE = 1;

    private SauceType type;
    private double weight;

    public Sauce(SauceType type, double weight) {
        this.type = type;
        this.weight = weight;
    }

    @Override
    public double price() {
        return BASE_PRICE;
    }

    @Override
    public double caloriesPer100grams() {
        return this.type.caloriesPer100Grams();
    }

    @Override
    public double weight() {
        return weight;
    }

    @Override
    public double calories() {
        return this.caloriesPer100grams() * this.weight() / 100;
    }

    @Override
    public String toString() {
        return String.format("%s sauce (%.0fg) -- %.2f€", type, weight(), price());
    }

}
