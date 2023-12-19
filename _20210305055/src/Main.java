import java.util.Scanner;

public class Main {
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