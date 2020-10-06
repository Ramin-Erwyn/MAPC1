package td1.refactor.api.general;

import td1.refactory.api.general.FoodProduct;

public class Meat implements FoodProduct {

    public enum MeatType {
        BEEF, WHITEFISH;
        private MeatType type;
        private double weight;


        public Double price(){
            double rtr=0;
            if(this == WHITEFISH) {rtr= 6;}
            else {return rtr;}
            if (this == BEEF) {rtr =4;}
            else {return rtr;}
        }

        public int caloriesPer100grams() {
            double calorie = 0;
            if(this == BEEF) return 200;
            if(this == WHITEFISH) return 170;
            else return (int) calorie;
        }



     MeatType(MeatType type, double weight) {
        this.type = type;
        this.weight = weight;
    }


    public Double price() {
        return type.price() * weight / 100;
    }
    public double caloriesPer100grams() {
        return this.type.caloriesPer100grams();
    }

    public double calories() {
        return this.caloriesPer100grams() * this.weight() / 100;
    }

    public Double weight() {
        return weight;
    }
    public String toString() {
        return String.format("%s (%.0fg) -- %.2f€", type, weight(), price());
    }
}
