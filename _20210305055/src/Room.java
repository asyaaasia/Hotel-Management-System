import java.util.*;

abstract class Room {
    private int roomNumber;
    private boolean isOccupied;
    private Guest guest;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isOccupied = false;
        this.guest = null;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Guest getGuest() {
        return guest;
    }

    public void checkIn(Guest guest) {
        this.guest = guest;
        this.isOccupied = true;
    }

    public void checkOut() {
        this.guest = null;
        this.isOccupied = false;
    }

    interface Displayable {
        void displayInfo();
    }
}