package td1.refactor.api.general;


import java.util.List;

public class Burger implements FoodProduct {

    String name;
    List<FoodProduct> items;

    public Burger(String name, List<FoodProduct> items) {
        this.name = name;
        this.items = items;
    }

    public double calories() {
        return Math.ceil(items.stream().map(FoodProduct::calories).reduce(0.0, Double::sum));
    }

    public double caloriesPer100grams() {
        return Math.ceil(this.calories() * 100 / this.weight());
    }

    public double weight() {
        return Math.ceil(items.stream().map(FoodProduct::weight).reduce(0.0, Double::sum));
    }

    public double price() {
        return items.stream().map(FoodProduct::price).reduce(0.0, Double::sum);
    }

    public String toString() {
        final String DELIM = "--------------------\n";
        StringBuilder buffer = new StringBuilder();
        buffer.append(String.format("*** Menu %s ***\n", name));
        for (Object item : items) {
            buffer.append(String.format("- %s\n", item));
        }
        buffer.append(DELIM)
                .append(String.format("price:         %.2f\n", price()))
                .append(DELIM)
                .append(String.format("calories:    %f\n", calories()))
                .append(String.format("calories/100:    %f\n", caloriesPer100grams()))
                .append(DELIM);
        return buffer.toString();
    }
}
