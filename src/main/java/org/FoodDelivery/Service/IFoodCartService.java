package org.FoodDelivery.Service;

import org.FoodDelivery.Model.FoodCart;
import org.FoodDelivery.Model.Item;


public interface IFoodCartService {
	
	public FoodCart addItemToCart(FoodCart cart);
	public FoodCart increaseQuantity(FoodCart cart,Item item,int quantity);
	public FoodCart reduceQuantity(FoodCart cart,Item item,int quantity);
	public FoodCart removeItem(FoodCart cart,Item item);
	public FoodCart ClearCart(FoodCart cart);
	public FoodCart findCartById(Long cartId);

}
