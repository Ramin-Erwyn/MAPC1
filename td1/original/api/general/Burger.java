package td1.original.api.general;

import java.util.List;

public class Burger implements td1.refactor.api.general.Product{

    String name;
    List<td1.refactor.api.general.Product> items;

    public Burger(String name, List<td1.refactor.api.general.Product> items) {
        this.name = name;
        this.items = items;
    }

    public double weight() {
        return items.stream().map(td1.refactor.api.general.Product::weight).reduce(0.0, Double::sum);
    }

    public double price() {
        return items.stream().map(td1.refactor.api.general.Product::price).reduce(0.0, Double::sum);
    }

    public String toString() {
        final String DELIM = "--------------------\n";
        StringBuilder buffer = new StringBuilder();
        buffer.append(String.format("*** Menu %s ***\n", name));
        for (Object item : items) {
            buffer.append(String.format("- %s\n", item));
        }
        buffer.append(DELIM);
        buffer.append(String.format("price:         %.2f\n", price()));
        buffer.append(DELIM);
        return buffer.toString();
    }
}
