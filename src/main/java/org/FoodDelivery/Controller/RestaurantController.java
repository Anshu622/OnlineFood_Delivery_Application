package org.FoodDelivery.Controller;

import java.util.ArrayList;
import java.util.List;

import org.FoodDelivery.Model.FoodCart;
import org.FoodDelivery.Model.Item;
import org.FoodDelivery.Model.Restaurant;
import org.FoodDelivery.Model.User;
import org.FoodDelivery.Service.ItemService;
import org.FoodDelivery.Service.RestaurantService;
import org.FoodDelivery.Service.UserService;
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
@RequestMapping("/restaurant")
@SessionAttributes("userId")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private UserService userService;
	
	@GetMapping("/addrestaurant")
	public String addRestaurant(Model model) {
		Restaurant restaurant=new Restaurant();
		model.addAttribute("restaurant",restaurant);
		return "restaurant/addrestaurant";
	}
	
	@PostMapping("/addrestaurant")
	public String processAddRestaurant(@ModelAttribute("restaurant")Restaurant restaurant) {
		if(restaurantService.addRestaurant(restaurant)==null)
			return "restaurant/addfailed";
		else
			return "restaurant/addsuccess";
	}
	
	@GetMapping("/modifyrestaurant")
	public String modifyRestaurant(Model model) {
		Restaurant restaurant=new Restaurant();
		model.addAttribute("restaurant",restaurant);
		return "restaurant/modifyrestaurant";
	}
	
	@GetMapping("/fetchrestaurant")
	public String fetchRestaurant(@RequestParam("restaurantId") Integer restaurantId, Model model) {
		Restaurant restaurant=restaurantService.findRestaurantById(restaurantId);
		if(restaurant==null)
			return "restaurant/restaurantnotfound";
		else {
			model.addAttribute("restaurant",restaurant);
			return "restaurant/modifyfound";
		}
	}
	
	@PostMapping("/modifyrestaurantprocess")
	public String processModifyRestaurant(@ModelAttribute("restaurant")Restaurant restaurant) {
		if(restaurantService.updateRestaurant(restaurant)==null)
			return "restaurant/modifyfailed";
		else
			return "restaurant/modifysuccess";
	}
	
	@GetMapping("/deleterestaurant")
	public String deleteRestaurant(Model model) {
		Restaurant restaurant=new Restaurant();
		model.addAttribute("restaurant",restaurant);
		return "restaurant/deleterestaurant";
	}
	
	@GetMapping("/fetchfordeleterestaurant")
	public String fetchfordeleteRestaurant(@RequestParam("restaurantid") Integer restaurantId, Model model) {
		Restaurant restaurant=restaurantService.findRestaurantById(restaurantId);
		if(restaurant==null)
			return "restaurant/restaurantnotfound";
		else {
			model.addAttribute("restaurant",restaurant);
			return "restaurant/deletefound";
		}
	}
	
	@PostMapping("/deleterestaurantprocess")
	public String processDeleteRestaurant(@ModelAttribute("restaurant")Restaurant restaurant) {
		if(restaurantService.removeRestaurant(restaurant)==null)
			return "restaurant/deletefailed";
		else
			return "restaurant/deletesuccess";
	}
	
	
	@GetMapping("/listRestaurant")
	public String listRestaurants(Model model)
	{
		List<Restaurant> restaurant=restaurantService.viewRestaurant();
		model.addAttribute("restaurant",restaurant);
		return "restaurant/listRestaurant";
	}
	@GetMapping("/viewRestaurant")
	public String viewItem(Model model) {
		Long userId=(Long)model.getAttribute("userId");
		User user=userService.getUserById(userId);
		FoodCart cart=user.getCart();
		model.addAttribute("cart", cart);
		List<Restaurant> restaurant=restaurantService.viewRestaurant();
		model.addAttribute("restaurant",restaurant);
		return "restaurant/viewRestaurant";
	}
	
	

}
