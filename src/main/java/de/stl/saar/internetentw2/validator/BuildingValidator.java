package de.stl.saar.internetentw2.validator;

import de.stl.saar.internetentw2.constants.ErrorMessages;
import de.stl.saar.internetentw2.model.Building;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("buildingValidator")
public class BuildingValidator implements Validator{
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String message;

        if (o instanceof Building) {
            Building building = (Building) o;

            if (!checkBuildingNumber(building.getBuildingNumber())) {
                message = ErrorMessages.INVALID_BUILDING_NUMBER;
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
            }

            if (!checkFloorNumber(building.getFloorNumber())) {
                message = ErrorMessages.INVALID_FLOOR_NUMBER;
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
            }

            if (!checkRoomNumber(building.getRoomNumber())) {
                message = ErrorMessages.INVALID_ROOM_NUMBER;
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
            }
        }
    }

    private boolean checkBuildingNumber(int buildingNumber) {
        return buildingNumber >= 1 && buildingNumber <= 8;
    }

    private boolean checkFloorNumber(int floorNumber) {
        return floorNumber >= 0 && floorNumber <= 2;
    }

    private boolean checkRoomNumber(int roomNumber) {
        return roomNumber >= 1 && roomNumber <= 20;
    }
}
