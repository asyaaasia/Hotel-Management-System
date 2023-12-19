
import java.util.*;

class GuestList<T extends Guest> {
    private List<T> guests;

    public GuestList() {
        this.guests = new ArrayList<>();
    }

    public void addGuest(T guest) {
        guests.add(guest);
    }
}