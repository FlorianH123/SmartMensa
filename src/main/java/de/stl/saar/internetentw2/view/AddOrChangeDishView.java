package de.stl.saar.internetentw2.view;

import de.stl.saar.internetentw2.model.Category;
import de.stl.saar.internetentw2.model.Dish;
import de.stl.saar.internetentw2.service.interfaces.DishService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class AddOrChangeDishView implements Serializable{
    @Autowired
    private DishService dishService;
    private Dish dish;

    @PostConstruct
    public void init() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String dishIdString = facesContext.getExternalContext().getRequestParameterMap().get("dishId");

        if (dishIdString != null) {
            int dishId = Integer.parseInt(dishIdString);
            dish = dishService.getDishById(dishId);
        } else {
            dish = new Dish("", 0.0, null, "");
        }


    }

    public String saveDish(Dish dish) {
        dishService.saveDish(dish);

        return "administration";
    }

// Get Methods ---------------------------------------------------------------------------------------------------------

    public Dish getDish() {
        return dish;
    }

    public Category[] getCategories() {
        return Category.values();
    }
}
