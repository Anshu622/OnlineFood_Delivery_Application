package org.FoodDelivery.Service;

import java.util.List;
import java.util.Optional;

import org.FoodDelivery.Model.Address;
import org.FoodDelivery.Model.Login;
import org.FoodDelivery.Model.User;

public interface UserService {
	
	public User addUser(User user);
	 public User getUserById(Long userId);
	 public List<User> viewAll();
}
