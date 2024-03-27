package org.FoodDelivery.Repository;

import java.util.Optional;

import org.FoodDelivery.Model.Login;
import org.FoodDelivery.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	public User findByemail(String email);
}
