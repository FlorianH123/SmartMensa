package de.stl.saar.internetentw2.view;

import de.stl.saar.internetentw2.constants.ErrorMessages;
import de.stl.saar.internetentw2.model.Category;
import de.stl.saar.internetentw2.model.Dish;
import de.stl.saar.internetentw2.service.interfaces.DishService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
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

// Validation ----------------------------------------------------------------------------------------------------------

    public void validateDishName(FacesContext facesContext,
                                 UIComponent component,
                                 Object value) throws ValidatorException {

        String dishName = (String) value;

        if (dishName.trim().isEmpty()) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    ErrorMessages.ERROR, ErrorMessages.INVALID_DISH_NAME));
        }
    }

    public void validateDishPrice(FacesContext facesContext,
                                  UIComponent component,
                                  Object value) throws ValidatorException {

        double price = (Double) value;

        if (price < 0.5 || price > 5.5) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, ErrorMessages.ERROR,
                    ErrorMessages.INVALID_DISH_PRICE));
        }
    }

// ---------------------------------------------------------------------------------------------------------------------
}
