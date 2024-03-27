package org.FoodDelivery.Service;

import org.FoodDelivery.Model.Login;
import org.FoodDelivery.Model.User;
import org.springframework.stereotype.Service;

@Service
public interface loginService {
	
	public User validateLogin(String email,String password);
  

}
