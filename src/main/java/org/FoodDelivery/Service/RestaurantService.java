package org.FoodDelivery.Service;

import java.util.List;

import org.FoodDelivery.Model.Item;
import org.FoodDelivery.Model.Restaurant;

public interface RestaurantService {
	
	public Restaurant addRestaurant(Restaurant res);
	public Restaurant updateRestaurant(Restaurant res);
	public Restaurant findRestaurantById(Integer restaurantId);
	public Restaurant removeRestaurant(Restaurant res);
	public List<Restaurant> viewRestaurant();
	public List<Restaurant> viewNearByRestaurant(String location);
	public List<Restaurant> viewRestaurantByItemName(String name);
	


}

