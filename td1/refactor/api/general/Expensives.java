package td1.refactor.api.general;

import td1.refactor.api.general.Meat.MeatType;
import java.util.ArrayList;
import java.util.List;

import static td1.refactor.api.general.Meat.MeatType.*;
import static td1.refactor.api.general.Portion.BIG;
import static td1.refactor.api.general.Portion.MEDIUM;
import static td1.refactor.api.general.Portion.SMALL;
import static td1.refactor.api.general.Sauce.SauceType.*;
/*
import static td1.refactor.api.general.MenuType.CHEESE_MENU;
import static td1.refactor.api.general.MenuType.FISH_MENU;
import static td1.refactor.api.general.MenuType.MEAT_MENU;
import static td1.refactor.api.general.MenuType.OWN_STYLE;
*/
import static td1.refactor.api.general.MenuType.*;
public class ExpensiveRestaurant implements Restaurant {

    private List<td1.refactor.api.general.FoodProduct> items;
    private String menuName;

    public ExpensiveRestaurant() {
        this.items = new ArrayList<>();
        this.menuName = "";
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int PortionCon(Portion portion) {

        if( portion == SMALL) return 100;
        if( portion == MEDIUM) return 200;
        if( portion == BIG) return 400;
    }

    public Restaurant order_menu(MenuType type) {
        switch (type) {
            case MEAT_MENU -> {
                this.setMenuName("BigMarcel");
                this.items.add(new Meat(BEEF, this.PortionCon(BIG)));
                this.items.add(new Sauce(BURGER, 20));
                this.items.add(new DeepFriedOnions(20));
                this.items.add(new Tomato(10));
            }
            case FISH_MENU -> {
                this.setMenuName("FiletO'Poisson");
                this.items.add(new Meat(WHITEFISH, this.PortionCon(MEDIUM)));
                this.items.add(new Sauce(BEARNAISE, 20));
            }
            case CHEESE_MENU -> {
                this.setMenuName("MaxeeCheesee");
                this.items.add(new Meat(BEEF, this.PortionCon(MEDIUM)));
                this.items.add(new Cheddar(30));
                this.items.add(new DeepFriedOnions(20));
            }
        }
        return this;
    }

    public Restaurant with_onions() {
        this.items.add(new DeepFriedOnions(20));
        return (Restaurant) this;
    }

    public Restaurant with_cheese() {
        this.items.add(new Cheddar(30));
        return (Restaurant) this;
    }

    public Restaurant with_sauce() {
        this.items.add(new Sauce(type,20));
        return (Restaurant) this;
    }

    public Restaurant order_personal(Portion portion, MeatType type) {
        this.setMenuName("Own Style");
        this.items.add(new Meat(type, this.PortionCon(portion)));
        return (Restaurant) this;
    }

}
