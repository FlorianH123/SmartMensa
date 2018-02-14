package de.stl.saar.internetentw2.model;

import java.util.Objects;

public class Building {
    private int buildingNumber;
    private int floorNumber;
    private int roomNumber;

    public Building(int buildingNumber, int floorNumber, int roomNumber) {
        this.buildingNumber = buildingNumber;
        this.floorNumber = floorNumber;
        this.roomNumber = roomNumber;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return buildingNumber == building.buildingNumber &&
                floorNumber == building.floorNumber &&
                roomNumber == building.roomNumber;
    }

    @Override
    public int hashCode() {

        return Objects.hash(buildingNumber, floorNumber, roomNumber);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(buildingNumber);
        sb.append(floorNumber);

        if (roomNumber < 10) {
            sb.append("0");
            sb.append(roomNumber);
        } else {
            sb.append(roomNumber);
        }

        return sb.toString();
    }
}
