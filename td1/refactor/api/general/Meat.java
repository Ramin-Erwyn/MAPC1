package td1.refactor.api.general;

import td1.refactory.api.general.FoodProduct;

public class Meat implements FoodProduct {

    public enum MeatType {
        BEEF, WHITEFISH;


        public double price() {
            double rtr=0;
            if(this == WHITEFISH) rtr= 6;
            if (this ==BEEF) rtr =4;
            else return rtr;
        }

        public double caloriesPer100grams() {
            double calorie = 0.0;
            if(this == BEEF) return 200;
            if(this == WHITEFISH) return 170;
            else return calorie;
    }

    private MeatType type;
    private double weight;

    public Meat(MeatType type, double weight) {
        this.type = type;
        this.weight = weight;
    }

    @Override
    public double price() {
        return type.price() * weight / 100;
    }

    @Override
    public double caloriesPer100grams() {
        return this.type.caloriesPer100grams();
    }

    @Override
    public double calories() {
        return this.caloriesPer100grams() * this.weight() / 100;
    }

    @Override
    public double weight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("%s (%.0fg) -- %.2f€", type, weight(), price());
    }
}
