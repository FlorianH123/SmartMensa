package de.stl.saar.internetentw2.view;

import de.stl.saar.internetentw2.model.Building;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import static de.stl.saar.internetentw2.constants.Messages.ORDER_SUCCESSFUL;
import static de.stl.saar.internetentw2.constants.Messages.ORDER_SUCCESSFUL_SUMMARY;

@ManagedBean
public class OrderConfirmationView {
    private Building building;
    private String name;

    public void confirmOrder() {
        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage(ORDER_SUCCESSFUL_SUMMARY,
                ORDER_SUCCESSFUL + building.toString()));
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
