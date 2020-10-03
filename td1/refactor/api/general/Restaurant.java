package td1.refactor.api.general;

import static td1.refactor.api.general.Meat.*;
import static td1.refactor.api.general.Sauce.*;

public interface Restaurant {
				enum MenuType {
								FISH_MENU, CHEESE_MENU, MEAT_MENU, OWN_STYLE_MENU
				}
				enum  Portion {
								SMALL, MEDIUM, BIG;
				}
				int valuePortion(Portion portion);
				Restaurant order_menu(MenuType type);
				Restaurant with_onions();
				Restaurant with_cheese();
				Restaurant with_sauce(SauceType type);
				Restaurant order_personal(Portion portion, MeatType type);
				Burger cook();
}
