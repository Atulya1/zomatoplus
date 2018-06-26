package com.thinkxfactor.zomatoplus.controller;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thinkxfactor.zomatoplus.models.Restaurant;
import com.thinkxfactor.zomatoplus.repository.RestaurantRepository;

import com.thinkxfactor.zomatoplus.models.Items;
import com.thinkxfactor.zomatoplus.repository.ItemsRepository;


@RestController
@RequestMapping("/Restaurant")
public class RestaurantController {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private ItemsRepository itemRepository;

	@PostMapping("/create")
	public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
		Restaurant persistedRes=restaurantRepository.saveAndFlush(restaurant);
		return persistedRes;
	}
	
	@GetMapping("/listAll")
	public List<Restaurant> listAll() {
		
		return restaurantRepository.findAll();
	}
	
	@PostMapping("/addItems")
	public Items addItems(@RequestBody Items itm) {
		Items persistedRes=itemRepository.saveAndFlush(itm);
		return persistedRes;
	}
	
}
