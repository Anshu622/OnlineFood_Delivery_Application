package org.FoodDelivery.Repository;


import org.FoodDelivery.Model.FoodCart;
import org.FoodDelivery.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodCartRepository extends JpaRepository<FoodCart,Long>{
  
	
}
