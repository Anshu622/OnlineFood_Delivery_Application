package org.FoodDelivery.Service;

import java.util.List;
import java.util.Optional;

import org.FoodDelivery.Model.OrderDetails;
import org.FoodDelivery.Model.Restaurant;
import org.FoodDelivery.Repository.FoodCartRepository;
import org.FoodDelivery.Repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IOrderServiceImpl implements IOrderService {
	
	@Autowired
    private OrderDetailsRepository orderDetailsRepository;
	

	@Override
	public OrderDetails addOrder(OrderDetails order) {
		// TODO Auto-generated method stub
		return orderDetailsRepository.save(order);
	}


	@Override
	public OrderDetails findOrderById(Integer orderId) {
		Optional<OrderDetails> opt=orderDetailsRepository.findById(orderId);
		if(opt.isPresent())
			return opt.get();
		return null;
	}

//	@Override
//	public OrderDetails updateOrder(OrderDetails order) {
//		return orderDetailsRepository.save(order);
//	}
//
}
