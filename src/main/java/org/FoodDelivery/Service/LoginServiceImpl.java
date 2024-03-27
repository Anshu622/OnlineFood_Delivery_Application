package org.FoodDelivery.Service;

import java.util.Optional;

import org.FoodDelivery.Model.Login;
import org.FoodDelivery.Model.LoginToken;
import org.FoodDelivery.Model.User;
import org.FoodDelivery.Repository.LoginRepository;
import org.FoodDelivery.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements loginService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private User user;;
	

	@Override
	public User validateLogin(String email, String password) {
		user=userRepository.findByemail(email);
		
		if(user==null)
		return null;
		else {
			if(!user.getPassword().equals(password))
				return null;
			else 
				return user;
		}
	}


}
