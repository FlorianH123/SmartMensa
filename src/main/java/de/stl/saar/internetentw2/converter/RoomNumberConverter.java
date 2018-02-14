package de.stl.saar.internetentw2.converter;

import de.stl.saar.internetentw2.constants.ErrorMessages;
import de.stl.saar.internetentw2.model.Building;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.faces.validator.ValidatorException;
import java.io.BufferedReader;

@FacesConverter(forClass = Building.class)
public class RoomNumberConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        int roomNumber;
        int buildingNumber;
        int floorNumber;

        if (s.length() != 4) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    ErrorMessages.ERROR, ErrorMessages.INVALID_ROOM_NUMBER_LENGTH));
        }

        buildingNumber = Integer.parseInt(s.substring(0, 1));
        floorNumber = Integer.parseInt(s.substring(1, 2));
        roomNumber = Integer.parseInt(s.substring(2));

        return new Building(buildingNumber, floorNumber, roomNumber);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        StringBuilder sb = new StringBuilder();

        if (o instanceof Building) {
            Building building = (Building) o;

            sb.append(building.getBuildingNumber());
            sb.append(building.getFloorNumber());

            if (building.getRoomNumber() < 10) {
                sb.append("0");
                sb.append(building.getRoomNumber());
            } else {
                sb.append(building.getRoomNumber());
            }
        }

        return sb.toString();
    }
}
