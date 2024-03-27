package org.FoodDelivery.Controller;

import org.FoodDelivery.Model.Item;
import org.FoodDelivery.Model.OrderDetails;
import org.FoodDelivery.Service.IOrderService;
import org.FoodDelivery.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderDetailsController {
	
	@Autowired
	private IOrderService IOrderService;
	
	@GetMapping("/addorder")
	public String addOrder(Model model) {
		OrderDetails order=new OrderDetails();
		model.addAttribute(order);
		return "orderdetails/addorder";

}
	@PostMapping("/addorder")
	public String addItemProcess(@ModelAttribute("orderdetails") OrderDetails order) {
		
		IOrderService.addOrder(order);
		return "orderdetails/addsuccess";
	
}
	
	
}
