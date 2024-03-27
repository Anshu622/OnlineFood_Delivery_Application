package org.FoodDelivery.Service;

import java.util.List;

import org.FoodDelivery.Model.OrderDetails;
import org.FoodDelivery.Model.Restaurant;
import org.springframework.stereotype.Service;

@Service
public interface IOrderService {
	public OrderDetails addOrder(OrderDetails order);
	public OrderDetails findOrderById(Integer orderId);
//	public OrderDetails updateOrder(OrderDetails order);
//	public OrderDetails removeOrder(OrderDetails order);
//	public OrderDetails viewOrder(OrderDetails order);
//	public List<OrderDetails> viewAllOrders(Restaurant res);
//	public List<OrderDetails> viewAllOrders(Customer customer);

}
