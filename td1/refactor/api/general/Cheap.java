package td1.refactor.api.general;



import td1.refactor.api.general.Meat.MeatType;

import java.util.ArrayList;
import java.util.List;

import static td1.refactor.api.general.Meat.MeatType.*;
import static td1.refactor.api.general.Restaurant.Portion.*;
import static td1.refactor.api.general.Sauce.*;
import static td1.refactor.api.general.Sauce.SauceType.*;

public class CheapRestaurant implements Restaurant {

    private List<td1.refactory.api.general.FoodProduct> items;
    private String menuName;


    public CheapRestaurant() {
        this.items = new ArrayList<>();
        this.menuName = "";
    }

    @Override
    public int valuePortion(Portion portion) {
        if( portion == SMALL) return 50;
        if( portion == MEDIUM) return 100;
        if( portion == BIG) return 200;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Override
    public Restaurant order_menu(MenuType type) {
        switch (type) {
            case FISH_MENU -> {
                this.setMenuName("Fishy");
                this.items.add(new Meat(WHITEFISH, this.valuePortion(SMALL)));
                this.items.add(new Sauce(BEARNAISE, 40));
            }
            case MEAT_MENU -> {
                this.setMenuName("Beefy");
                this.items.add(new Meat(BEEF, this.valuePortion(MEDIUM)));
                this.items.add(new Sauce(BURGER, 40));
                this.items.add(new DeepFriedOnions(10));
                this.items.add(new Cheddar(10));
            }
            case CHEESE_MENU -> {
                this.setMenuName("Cheesy");
                this.items.add(new Meat(BEEF, this.valuePortion(SMALL)));
                this.items.add(new Cheddar(10));
            }
        }
        return this;
    }

    @Override
    public Restaurant with_onions() {
        this.items.add(new DeepFriedOnions(10));
        return this;
    }

    @Override
    public Restaurant with_cheese() {
        this.items.add(new Cheddar(10));
        return this;
    }

    @Override
    public Restaurant with_sauce(SauceType type) {
        this.items.add(new Sauce(type, 40));
        return this;
    }

    @Override
    public Restaurant order_personal(Portion portion, MeatType type) {
        this.setMenuName("Own Style");
        this.items.add(new Meat(type, this.valuePortion(portion)));
        return this;
    }

    @Override
    public Burger cook() {
        return new Burger(this.menuName, items);
    }
}
