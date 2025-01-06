import java.util.Scanner;

// Abstract Class
abstract class Customer {
    private String nationalID;
    private String name;
    private int age;
    private String address;

    // Getters and Setters
    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

// Interface
interface Booking {
    void bookTicket();
    double calculatePayment(double distance);
}

// Ticket Booking Class
class TicketBooking extends Customer implements Booking {

    // Calculate price based on distance
    @Override
    public double calculatePayment(double distance) {
        double price = 0.0;

        if (distance < 500) {
            price = 500;
        } else if (distance >= 500 && distance <= 1000) {
            price = 5000;
        } else if (distance > 1000 && distance <= 5000) {
            price = 6000;
        } else if (distance > 5000 && distance <= 10000) {
            price = 8000;
            // Apply 15% VAT and 5% discount
            price = price - (price * 0.15) - (price * 0.05);
        }

        return price;
    }

    // Book ticket
    @Override
    public void bookTicket() {
        Scanner scanner = new Scanner(System.in);

        // Input National ID
        System.out.println("Enter National ID: ");
        setNationalID(scanner.nextLine());

        // Input Name
        System.out.println("Enter Name: ");
        setName(scanner.nextLine());

        // Input and Validate Age
        while (true) {
            System.out.println("Enter Age (must be 20 or older): ");
            if (scanner.hasNextInt()) {
                int inputAge = scanner.nextInt();
                if (inputAge >= 20) {
                    setAge(inputAge);
                    break;
                } else {
                    System.out.println("Invalid age. Booking is not allowed for customers under 20 years.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number for age.");
                scanner.next(); // Clear invalid input
            }
        }

        // Consume remaining newline
        scanner.nextLine();

        // Input and Validate Address
        while (true) {
            System.out.println("Enter Address (cannot be Kigali): ");
            String inputAddress = scanner.nextLine();
            if (!inputAddress.equalsIgnoreCase("Kigali")) {
                setAddress(inputAddress);
                break;
            } else {
                System.out.println("Invalid address. Booking is not allowed for residents of Kigali.");
            }
        }

        // Input Distance
        double distance = 0.0;
        while (true) {
            System.out.println("Enter Distance (in km): ");
            if (scanner.hasNextDouble()) {
                double inputDistance = scanner.nextDouble();
                if (inputDistance > 0) {
                    distance = inputDistance;
                    break;
                }
            }
            System.out.println("Invalid distance. Please enter a positive number.");
            scanner.nextLine(); // Clear invalid input
        }

        // Calculate Price
        double price = calculatePayment(distance);

        // Print Ticket
        System.out.println("Booking successful!");
        printTicket(distance, price);
    }


    // Print ticket
    public void printTicket(double distance, double price) {
        System.out.println("\n----- Ticket Details -----");
        System.out.println("National ID: " + getNationalID());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Address: " + getAddress());
        System.out.println("Distance: " + distance + " km");
        System.out.println("Amount to be Paid: " + price);
        System.out.println("--------------------------");
    }
}

// Main Class
public class BusTicketBookingSystem {
    public static void main(String[] args) {
        TicketBooking ticketBooking = new TicketBooking();
        ticketBooking.bookTicket();
    }
}
