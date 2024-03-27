package org.FoodDelivery.Service;


import java.util.List;

import org.FoodDelivery.Model.Item;
import org.FoodDelivery.Model.Restaurant;

public interface ItemService {
	
	public Item addItem(Item item);
	public Item updateItem(Item item);
	public Item findItemById(Long ItemId);
	public Item removeItem(Item item);
	public List<Item> viewAllItems();
	//public List<Item> viewAllItems(Category cat);
	public List<Item> viewItemsByRestaurant(Item item);
	public List<Item> viewAllItemsByName(String name);
}