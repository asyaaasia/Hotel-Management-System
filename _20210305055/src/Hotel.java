import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
class Hotel implements Room.Displayable {
    private String name;
    private List<Room> rooms;

    public Hotel(String name) {
        this.name = name;
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Room getRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    @Override
    public void displayInfo() {
        System.out.println("Hotel: " + name);
        for (Room room : rooms) {
            System.out.print("Room " + room.getRoomNumber() + ": ");
            if (room.isOccupied()) {
                System.out.println("Occupied by " + room.getGuest().getName());
            } else {
                System.out.println("Available");
            }
        }
    }

    public void performHotelOperations(Scanner scanner) {
        while (true) {
            System.out.println("\nHotel Operations:");
            System.out.println("1. Display Room Occupancy");
            System.out.println("2. Check-in");
            System.out.println("3. Check-out");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayInfo();
                    break;

                case 2:
                    performCheckIn(scanner);
                    break;

                case 3:
                    performCheckOut(scanner);
                    break;

                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
                    break;
            }
        }
    }

    private void performCheckIn(Scanner scanner) {
        System.out.print("Enter guest name: ");
        String guestName = scanner.next();
        Guest guest = new Guest(guestName);

        System.out.print("Enter room number: ");
        int roomNumber = scanner.nextInt();
        Room selectedRoom = getRoomByNumber(roomNumber);

        if (selectedRoom != null) {
            selectedRoom.checkIn(guest);
            System.out.println(guestName + " checked into Room " + roomNumber);
        } else {
            System.out.println("Room not found!");
        }
    }

    private void performCheckOut(Scanner scanner) {
        System.out.print("Enter room number to check-out: ");
        int checkoutRoomNumber = scanner.nextInt();
        Room checkoutRoom = getRoomByNumber(checkoutRoomNumber);

        if (checkoutRoom != null && checkoutRoom.isOccupied()) {
            checkoutRoom.checkOut();
            System.out.println("Checked out from Room " + checkoutRoomNumber);
        } else {
            System.out.println("Room not occupied or not found!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel("Sample Hotel");

        SuiteRoom suiteRoom1 = new SuiteRoom(101, "Presidential");
        SuiteRoom suiteRoom2 = new SuiteRoom(102, "Executive");

        hotel.addRoom(suiteRoom1);
        hotel.addRoom(suiteRoom2);

        hotel.displayInfo();

        hotel.performHotelOperations(scanner);
    }
}