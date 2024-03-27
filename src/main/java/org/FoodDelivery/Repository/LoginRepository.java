package org.FoodDelivery.Repository;

import java.util.Optional;

import org.FoodDelivery.Model.Item;
import org.FoodDelivery.Model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login,Integer>{
	 public Login findByEmail(String email);
	 
}
