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
public class RestaurantServiceImpl implements RestaurantService{
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	
	public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}

	@Override
	public Restaurant addRestaurant(Restaurant res) {
		return restaurantRepository.save(res);
	}

	@Override
	public Restaurant updateRestaurant(Restaurant res) {
		return restaurantRepository.save(res);
	}

	@Override
	public Restaurant removeRestaurant(Restaurant res) {
		restaurantRepository.delete(res);
		return res;
	}

	@Override
	public List<Restaurant> viewRestaurant() {
		return restaurantRepository.findAll();
	}

	@Override
	public List<Restaurant> viewNearByRestaurant(String location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Restaurant> viewRestaurantByItemName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurant findRestaurantById(Integer restaurantId) {
		Optional<Restaurant> opt=restaurantRepository.findById(restaurantId);
		if(opt.isPresent())
			return opt.get();
		else
			return null;
		
		
		
	}

}
