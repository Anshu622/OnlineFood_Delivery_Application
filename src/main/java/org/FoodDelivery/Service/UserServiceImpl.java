package org.FoodDelivery.Service;

import java.util.List;
import java.util.Optional;

import org.FoodDelivery.Model.Address;
import org.FoodDelivery.Model.Login;
import org.FoodDelivery.Model.User;
import org.FoodDelivery.Repository.AddressRepository;
import org.FoodDelivery.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public User addUser(User user) {
		addressRepository.save(user.getAddress());
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long userId) {
		Optional<User> opt=userRepository.findById(userId);
		if(opt.isPresent())
			return opt.get();
		else
		return null;
	}

	@Override
	public List<User> viewAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}	


}
