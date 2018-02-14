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
        StringBuilder sb = new StringBuilder();
        boolean validationFailure = false;

        if (o instanceof Building) {
            Building building = (Building) o;

            if (!checkBuildingNumber(building.getBuildingNumber())) {
                sb.append(ErrorMessages.INVALID_BUILDING_NUMBER + " ");
                validationFailure = true;
            }

            if (!checkFloorNumber(building.getFloorNumber())) {
                sb.append(ErrorMessages.INVALID_FLOOR_NUMBER + " ");
                validationFailure = true;
            }

            if (!checkRoomNumber(building.getRoomNumber())) {
                sb.append(ErrorMessages.INVALID_ROOM_NUMBER + " ");
                validationFailure = true;
            }

            if (validationFailure) {
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        ErrorMessages.ERROR, sb.toString()));
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
