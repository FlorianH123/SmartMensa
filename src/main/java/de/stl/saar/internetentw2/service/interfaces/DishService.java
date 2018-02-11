package de.stl.saar.internetentw2.service.interfaces;

import de.stl.saar.internetentw2.model.Dish;

import java.util.List;


public interface DishService {
	void initializeDatabase();
	List<Dish> getAllDishes();
	void deleteDish (Long dishId);
	Dish getDishById (long dishId);
	void saveDish(Dish dish);
}
