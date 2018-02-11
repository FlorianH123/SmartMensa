package de.stl.saar.internetentw2.service.classes;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;

import de.stl.saar.internetentw2.dao.entity.DishEntity;
import de.stl.saar.internetentw2.dao.interfaces.DishRepository;
import de.stl.saar.internetentw2.model.Category;
import de.stl.saar.internetentw2.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.stl.saar.internetentw2.service.interfaces.DishService;

@Service
@ApplicationScoped
public class DishServiceImpl implements DishService {
	@Autowired
	DishRepository dishRepository;

	@PostConstruct
	public void initialize() {
		initializeDatabase();
	}
	
	@Override
	public void initializeDatabase() {
		dishRepository.save(new DishEntity("Baumkuchen", 2.0, Category.DESSERT, "baumkuchen"));
		dishRepository.save(new DishEntity("Creme Brulee", 2.5, Category.DESSERT, "cremeBrulee"));
		dishRepository.save(new DishEntity("Flammkuchen", 7.5, Category.MAIN_DISH, "flammkuchen"));
		dishRepository.save(new DishEntity("Grießnockerl-Suppe", 4, Category.SOUP, "griessnockerlsuppe"));
		dishRepository.save(new DishEntity("Pudding", 2, Category.DESSERT, "pudding"));
		dishRepository.save(new DishEntity("Rindfleischsuppe", 3.5, Category.SOUP, "rindfleischsuppe"));
		dishRepository.save(new DishEntity("Rumänischer Salat", 3.5, Category.SALAD, "rumaenischerSalat"));
		dishRepository.save(new DishEntity("Einfach nur Salat", 3.5, Category.SALAD, "salat"));
		dishRepository.save(new DishEntity("Wiener Schnitzel", 7.0, Category.MAIN_DISH, "schnitzel"));
		dishRepository.save(new DishEntity("Tomate-Mozarella", 4.0, Category.SALAD, "tomateMozarella"));
	}

	@Override
	public List<Dish> getAllDishes() {
		ArrayList<Dish> dishes = new ArrayList<Dish>();

		for (DishEntity dishEntity : dishRepository.findAll()) {
			Dish dish = createDish(dishEntity);
			dishes.add(dish);
		}

		return dishes;
	}

	public void saveDish(Dish dish) {
        DishEntity savedDish = dishRepository.findOne(dish.getId());

	    if (savedDish != null) {
	        savedDish.setName(dish.getName());
	        savedDish.setPrice(dish.getPrice());
	        savedDish.setCategory(dish.getCategory());
        } else {
            savedDish = new DishEntity(dish.getName(), dish.getPrice(), dish.getCategory(), "");
        }

        dishRepository.save(savedDish);
    }

	public Dish getDishById(long dishId) {
		return createDish(dishRepository.findOne(dishId));
	}

	private List<Dish> createDishes(List<DishEntity> dishEntities) {
		List<Dish> dishes = new ArrayList<Dish>();

		for (DishEntity dishEntity: dishEntities) {
			Dish dish = createDish(dishEntity);
			dishes.add(dish);
		}

		return dishes;
	}

	private Dish createDish(DishEntity dishEntity) {
		long dishId = dishEntity.getDishId();
		String name = dishEntity.getName();
		double price = dishEntity.getPrice();
		Category category = dishEntity.getCategory();
		String image = dishEntity.getImageName();

		return new Dish(dishId, name, price, category, image);
	}

	public void deleteDish(Long dishId) {
		dishRepository.delete(dishId);
	}
}
