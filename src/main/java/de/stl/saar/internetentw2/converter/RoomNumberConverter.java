package de.stl.saar.internetentw2.converter;

import de.stl.saar.internetentw2.model.Building;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Building.class)
public class RoomNumberConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        int roomNumber;
        int buildingNumber = Integer.parseInt(s.substring(0,1));
        int floorNumber = Integer.parseInt(s.substring(1,2));



        roomNumber = Integer.parseInt(s.substring(2));

        return new Building(buildingNumber, floorNumber, roomNumber);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        return o.toString();
    }
}
