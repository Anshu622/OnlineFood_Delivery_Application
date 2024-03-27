package org.FoodDelivery.Repository;

import java.util.List;

import org.FoodDelivery.*;
import org.FoodDelivery.Model.Item;
import org.FoodDelivery.Model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Integer>{
	
}
