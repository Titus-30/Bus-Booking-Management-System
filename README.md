# Bus Ticket Booking System

A simple Java application that simulates a bus ticket booking system. This system allows customers to book tickets, calculates the price based on the travel distance, and prints out ticket details. The program enforces several rules, such as age validation and restrictions based on the address.

## Features

- **Customer Information**: Collects National ID, Name, Age, and Address.
- **Booking Conditions**: 
  - Only customers aged 20 or older can book tickets.
  - Customers from Kigali are not allowed to book tickets.
- **Pricing Logic**: The price is calculated based on the distance the customer will travel:
  - 0 to 500 km: 500
  - 500 to 1000 km: 5000
  - 1000 to 5000 km: 6000
  - 5000 to 10000 km: 8000 (with 15% VAT and 5% discount applied).
- **Ticket Printing**: After booking, the system prints the ticket details including the customer’s information and calculated payment.

## Technologies Used

- Java

## Classes and Interfaces

### `Customer` (Abstract Class)
- Contains fields for storing the customer’s `nationalID`, `name`, `age`, and `address`.
- Provides getter and setter methods for these fields.

### `Booking` (Interface)
- Declares methods `bookTicket()` and `calculatePayment(double distance)` which must be implemented by any class that implements this interface.

### `TicketBooking` (Class)
- Inherits from `Customer` and implements the `Booking` interface.
- Contains the logic to book a ticket, calculate payment based on distance, and print the ticket.

### `BusTicketBookingSystem` (Main Class)
- The main entry point of the application.
- Calls the `bookTicket()` method to initiate the booking process.

## How to Run

1. Clone the repository to your local machine:
   ```bash
   git clone https://github.com/yourusername/bus-ticket-booking-system.git
