package de.stl.saar.internetentw2.view;

import de.stl.saar.internetentw2.model.Dish;
import de.stl.saar.internetentw2.service.interfaces.DishService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class OrderView implements Serializable {
    @Autowired
    private DishService dishService;
    private List<Dish> shoppingCard;
    private double totalCosts = 0.0;

    @PostConstruct
    public void init() {
        shoppingCard = new ArrayList<Dish>();
    }

    public void addDishToShoppingCard(Dish dish) {
        shoppingCard.add(dish);
        calculateTotal();
    }

    public void removeDishFromShoppingCard(Dish dish) {
        shoppingCard.remove(dish);
        calculateTotal();
    }

    private void calculateTotal() {
        totalCosts = 0.0;

        for (Dish dish : shoppingCard) {
            totalCosts += dish.getPrice();
        }
    }

    public List<Dish> getShoppingCard() {
        return shoppingCard;
    }

    public double getTotalCosts() {
        return totalCosts;
    }


}