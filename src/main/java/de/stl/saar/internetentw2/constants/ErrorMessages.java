package de.stl.saar.internetentw2.constants;

import javax.annotation.ManagedBean;

@ManagedBean
public class ErrorMessages {
    public static final String ERROR = "Fehler!";
    public static final String INVALID_BUILDING_NUMBER = "Die Gebäudenummer muss zwischen 1 und 8 liegen!";
    public static final String INVALID_FLOOR_NUMBER = "Die Etagennummer muss zwischen 0 und 2 liegen!";
    public static final String INVALID_ROOM_NUMBER = "Die Raumnummer muss zwischen 1 und 20 liegen!";
    public static final String INVALID_ROOM_NUMBER_LENGTH = "Die Raumnummer ist nicht vier-stellig!";
    public static final String NO_DISH_SELECTED = "Sie müssen mindestesn ein Gericht auswählen";

    private static final String INVALID_DISH_NAME = "Einen Namen braucht das Essen schon!";
    private static final String INVALID_DISH_PRICE = "Ein Essen kostet hier zwischen 50 Cent und 5,50 Euro!";
    private static final String INVALID_NAME = "Ein Name muss angeben werden!";

    public String getInvalidDishName() {
        return INVALID_DISH_NAME;
    }

    public String getInvalidDishPrice() {
        return INVALID_DISH_PRICE;
    }

    public String getInvalidName() {
        return INVALID_NAME;
    }
}
