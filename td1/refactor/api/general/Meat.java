package td1.refactor.api.general;
import td1.refactor.api.general.FoodProduct.*;
import td1.refactor.api.general.FoodConstituent;
public class Meat implements FoodProduct {

    public enum MeatType implements FoodConstituent {
        BEEF, WHITEFISH;


        public double calories_per_100g(){
            double rtr = 0;
            switch (this) {
                case WHITEFISH:
                    rtr = 170;
                    break;
                case BEEF :
                default:
                    rtr = 200;
            }
            return rtr;
        }
        public double price() {
            double rtr;
            switch (this) {
                case WHITEFISH:
                    rtr = 6;
                    break;
                case BEEF:
                default:
                    rtr = 4;
            }
            return rtr;
        }
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
    public double weight() {
        return weight;
    }

    public double calories_per_100g(){
        return type.calories_per_100g();
    }

    @Override
    public String toString() {
        return String.format("%s (%.0fg) -- %.2f€", type, weight(), price());
    }
}