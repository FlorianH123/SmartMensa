package de.stl.saar.internetentw2.view;

import de.stl.saar.internetentw2.model.Dish;
import de.stl.saar.internetentw2.service.interfaces.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;

import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class DishView implements Serializable{

    @Autowired
    private DishService dishService;
    private List<Dish> dishes;

    @PostConstruct
    public void init() {
        dishes = dishService.getAllDishes();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void deleteDish(Long dishId) {
        dishService.deleteDish(dishId);
        dishes = dishService.getAllDishes();
    }
}
