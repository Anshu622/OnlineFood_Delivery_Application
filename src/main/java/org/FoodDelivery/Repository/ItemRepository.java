package org.FoodDelivery.Repository;

import org.FoodDelivery.*;
import org.FoodDelivery.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

	@Repository
	public interface ItemRepository extends JpaRepository<Item,Long> {

	}



