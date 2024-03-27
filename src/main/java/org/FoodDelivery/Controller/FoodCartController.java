package org.FoodDelivery.Controller;

import java.util.ArrayList;
import java.util.List;

import org.FoodDelivery.Model.FoodCart;
import org.FoodDelivery.Model.Item;
import org.FoodDelivery.Model.Login;
import org.FoodDelivery.Model.OrderDetails;
import org.FoodDelivery.Model.Restaurant;
import org.FoodDelivery.Model.User;
import org.FoodDelivery.Repository.ItemRepository;
import org.FoodDelivery.Service.IFoodCartService;
import org.FoodDelivery.Service.IOrderServiceImpl;
import org.FoodDelivery.Service.ItemService;
import org.FoodDelivery.Service.UserService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/foodCart")
@SessionAttributes("userId")
public class FoodCartController {
	
	@Autowired
	private IFoodCartService FoodCartservice;
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private IOrderServiceImpl IOrderService;
	
	private OrderDetails orderDetails=new OrderDetails();
	
	@GetMapping("/addItemToCart")
	public String addItemToCart(@RequestParam("itemid")Long itemid,Model model) {
		Long userId=(Long)model.getAttribute("userId");
		User user=userService.getUserById(userId);
		FoodCart cart=user.getCart();
		Item item=itemService.findItemById(itemid);
		model.addAttribute("item",item);
		Restaurant restro=item.getRestaurant();
		model.addAttribute("restaurant", restro);
		cart.getItemList().add(item);
		FoodCartservice.addItemToCart(cart);
		model.addAttribute("cart",cart);
		return "foodCart/addItemToCart";
	}
	@GetMapping("/viewCart")
	public String viewCartItems(@RequestParam("cartid")Long cartId,Model model) {
		FoodCart cart=FoodCartservice.findCartById(cartId);
		List<Item> itemList=cart.getItemList();
		orderDetails.setCart(cart);
		model.addAttribute("orderDetails", orderDetails);
		IOrderService.addOrder(orderDetails);
		for(Item item:itemList) {
			item.setQuantity(1);
		}
		model.addAttribute("items",itemList);
		return "foodCart/viewCart";
	}
	@GetMapping("/viewAdminCart")
	public String viewCartItemsAdmin(@RequestParam("cartid")Long cartId,Model model) {
		FoodCart cart=FoodCartservice.findCartById(cartId);
		List<Item> itemList=cart.getItemList();
		orderDetails.setCart(cart);
		model.addAttribute("orderDetails", orderDetails);
		IOrderService.addOrder(orderDetails);
		model.addAttribute("items",itemList);
		return "foodCart/viewAdminCart";
	}
	@GetMapping("/orderAdminDetails")
	public String orderDetailsAdmin(@RequestParam("orderid")Integer orderId,Model model) {
		Long userId=(Long)model.getAttribute("userId");
		User user=userService.getUserById(userId);
		FoodCart cart=user.getCart();
		OrderDetails orderDetails=IOrderService.findOrderById(orderId);
		orderDetails.setCart(cart);
		List<Item> itemList=cart.getItemList();
		model.addAttribute("items",itemList);
		Double total=0.0;
		for(Item item:itemList) {
			item.setQuantity(1);
			total=total+(item.getCost()*item.getQuantity());
		}
		orderDetails.setTotalAmount(total);
		model.addAttribute("orderDetails",orderDetails);
		IOrderService.addOrder(orderDetails);
		return "foodCart/orderAdminDetails";
		
	}
	@GetMapping("/orderDetails")
	public String orderDetails(@RequestParam("orderid")Integer orderId,Model model) {
		Long userId=(Long)model.getAttribute("userId");
		User user=userService.getUserById(userId);
		FoodCart cart=user.getCart();
		OrderDetails orderDetails=IOrderService.findOrderById(orderId);
		orderDetails.setCart(cart);
		List<Item> itemList=cart.getItemList();
		model.addAttribute("items",itemList);
		Double total=0.0;
		for(Item item:itemList) {
			item.setQuantity(1);
			total=total+(item.getCost()*item.getQuantity());
		}
		orderDetails.setTotalAmount(total);
		model.addAttribute("orderDetails",orderDetails);
		IOrderService.addOrder(orderDetails);
		return "foodCart/orderDetails";
		
	}
	@GetMapping("/orderPlaced")
	public String orderPlaced(@RequestParam("orderId")Integer orderId,Model model) {
		orderDetails=IOrderService.findOrderById(orderId);
		orderDetails.setOrderStatus("Pending");
		IOrderService.addOrder(orderDetails);
		return "foodCart/orderPlaced";
	}
	@GetMapping("/changeStatus")
	public String changeStatus(@RequestParam("orderId")Integer orderId,Model model) {
		orderDetails=IOrderService.findOrderById(orderId);
		orderDetails.setOrderStatus("Accepted");
		IOrderService.addOrder(orderDetails);
		model.addAttribute("orderDetails", orderDetails);
		return "foodCart/changeStatus";
	}
	
	@GetMapping("/deleteItem")
	public String deleteItem(@RequestParam("itemid")Long itemId,Model model) {
		Long userId=(Long)model.getAttribute("userId");
		User user=userService.getUserById(userId);
		FoodCart cart=user.getCart();
		Item item=itemService.findItemById(itemId);
		FoodCart cartNew=FoodCartservice.removeItem(cart, item);
		if(cartNew.getItemList()==null)
			return "foodCart/emptyCart";
		FoodCartservice.addItemToCart(cartNew);
			model.addAttribute("cart", cartNew);
		return "foodCart/deleteItem";
	}
	
	@GetMapping("/deletecart")
	public String deleteCart(@RequestParam("cartid")Long cartId,Model model) {
		FoodCart cart=FoodCartservice.findCartById(cartId);
		List<Item> itemList=cart.getItemList();
		itemList.removeAll(itemList);
		cart.setItemList(itemList);
		FoodCartservice.addItemToCart(cart);
		return "foodCart/logout";
}
}