package org.FoodDelivery.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.FoodDelivery.Model.Item;
import org.FoodDelivery.Model.Restaurant;
import org.FoodDelivery.Repository.ItemRepository;
import org.FoodDelivery.Repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	public ItemServiceImpl(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Override
	public Item addItem(Item item) {
		restaurantRepository.save(item.getRestaurant());
		return itemRepository.save(item);
	}

	@Override
	public Item updateItem(Item item) {
		return itemRepository.save(item);
	}

	@Override
	public Item removeItem(Item item) {
		itemRepository.delete(item);
		return item;
	}
	
	@Override
	public List<Item> viewAllItems() {
		return itemRepository.findAll();
	}

	@Override
	public List<Item> viewItemsByRestaurant(Item item) {
		return null;
	}


	@Override
	public Item findItemById(Long itemId) {
		Optional<Item> opt=itemRepository.findById(itemId);
		if(opt.isPresent())
			return opt.get();
		else
			return null;

	}

	@Override
	public List<Item> viewAllItemsByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
