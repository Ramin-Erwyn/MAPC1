package td1.refactor.api.general;

public abstract class FactoryRestaurant {
				public enum RestaurantType {
								EXPENSIVE, CHEAP
				}
				public Restaurant createRestaurant() {
								Restaurant restaurant = instantiateRestaurant();
								return  restaurant;
				}

				protected abstract Restaurant instantiateRestaurant();
}
