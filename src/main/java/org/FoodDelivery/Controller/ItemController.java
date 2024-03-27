package org.FoodDelivery.Controller;

	import org.FoodDelivery.Model.Item;
	import org.FoodDelivery.Model.Restaurant;
	import org.FoodDelivery.Service.ItemService;
import org.FoodDelivery.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	@Autowired
	 private RestaurantService restaurantService;
	
	@GetMapping("/additem")
	public String addItem(@RequestParam("restaurantId")Integer restaurantId,Model model) {
		Item item=new Item();
		Restaurant restaurant=restaurantService.findRestaurantById(restaurantId);
		item.setRestaurant(restaurant);
		model.addAttribute(item);
		return "item/additem";
	}
	
	@PostMapping("/additem")
	public String processAddItem(@ModelAttribute("item")Item item) {
		if(itemService.addItem(item)==null)
			return "item/addfailed";
		else
			return "item/addsuccess";
	}
	
	@GetMapping("/modifyitem")
	public String modifyRestaurant(Model model) {
		List<Item> items=itemService.viewAllItems();
		model.addAttribute("items", items);
		return "item/modifyitem";
	}
	
	@GetMapping("/fetchitem")
	public String fetchItem(@RequestParam("itemid")Long itemId, Model model) {
		Item item=itemService.findItemById(itemId);
		model.addAttribute("item", item);
		return "item/modifyfound";
	}
	
	@PostMapping("/modifyitemprocess")
	public String processModifyItem(@ModelAttribute("item")Item item) {
		if(itemService.updateItem(item)==null)
			return "item/modifyfailed";
		else
			return "item/modifysuccess";
	}
	
	@GetMapping("/deleteitem")
	public String deleteRestaurant(Model model) {
		List<Item> items=itemService.viewAllItems();
		model.addAttribute("items", items);
		return "item/deleteitem";
	}
	
	@GetMapping("/fetchdeleteitem")
	public String fetchdeleteItem(@RequestParam("itemid")Long itemId, Model model) {
		Item item=itemService.findItemById(itemId);
		model.addAttribute("item", item);
		return "item/deletefound";
	}
	
	@PostMapping("/deleteitemprocess")
	public String processDeleteItem(@ModelAttribute("item")Item item) {
		if(itemService.removeItem(item)==null)
			return "item/deletefailed";
		else
			return "item/deletesuccess";
	}

	@GetMapping("/listitem")
	public String listItems(@RequestParam("restaurantId")Integer restaurantId,Model model) {
		List<Item> items=itemService.viewAllItems();
		List<Item> itemList=new ArrayList<>();
		for(Item item:items) {
			Restaurant restro=item.getRestaurant();
			if(restro.getRestaurantId()==restaurantId) {
				itemList.add(item);
			}
		}
		model.addAttribute("items", itemList);
		return "item/listitem";
	}
	
	@GetMapping("/viewitem")
	public String viewItem(@RequestParam("itemid")Long itemId, Model model) {
		Item item=itemService.findItemById(itemId);
		model.addAttribute("item", item);
		return "item/viewitem";
	}
	
	

}
