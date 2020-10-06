package td1.refactor.api.general;

import td1.refactor.api.general.FoodProduct;

public class Sauce implements FoodProduct {

    public enum SauceType implements FoodConstituent{
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

    public double price() {
        return BASE_PRICE;
    }

    public double caloriesPer100grams() {
        return this.type.caloriesPer100Grams();
    }

    public double weight() {
        return weight;
    }

    public double calories() {
        return this.caloriesPer100grams() * this.weight() / 100;
    }

    public String toString() {
        return String.format("%s sauce (%.0fg) -- %.2f€", type, weight(), price());
    }

}
