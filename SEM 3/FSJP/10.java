class RailwaySystem {
    private int availableTickets = 10;

    public synchronized void bookTicket(String passengerName, int seats) {
        if (seats <= 0) {
            System.out.println("Invalid booking request by " + passengerName);
            return;
        }
        if (availableTickets >= seats) {
            System.out.println(passengerName + " is booking " + seats + " ticket(s)...");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            availableTickets -= seats;
            System.out.println("Booking Confirmed for " + passengerName + "! Remaining tickets: " + availableTickets);
        } else {
            System.out.println("Booking Failed for " + passengerName + "! Requested: " + seats + ", Available: " + availableTickets);
        }
        System.out.println("----------------------------------------");
    }

    public synchronized void cancelTicket(String passengerName, int seats) {
        if (seats <= 0) {
            System.out.println("Invalid cancellation request by " + passengerName);
            return;
        }
        System.out.println(passengerName + " is cancelling " + seats + " ticket(s)...");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        availableTickets += seats;
        System.out.println("Cancellation Confirmed for " + passengerName + "! Remaining tickets: " + availableTickets);
        System.out.println("----------------------------------------");
    }

    public int getAvailableTickets() {
        return availableTickets;
    }
}

class BookingThread extends Thread {
    private RailwaySystem system;
    private String passengerName;
    private int seats;

    public BookingThread(RailwaySystem system, String passengerName, int seats) {
        this.system = system;
        this.passengerName = passengerName;
        this.seats = seats;
    }

    @Override
    public void run() {
        system.bookTicket(passengerName, seats);
    }
}

class CancellationThread extends Thread {
    private RailwaySystem system;
    private String passengerName;
    private int seats;

    public CancellationThread(RailwaySystem system, String passengerName, int seats) {
        this.system = system;
        this.passengerName = passengerName;
        this.seats = seats;
    }

    @Override
    public void run() {
        system.cancelTicket(passengerName, seats);
    }
}

class MultithreadingDemo {
    public static void main(String[] args) {
        System.out.println("--- Railway Reservation System (Multithreading) ---\n");

        RailwaySystem railway = new RailwaySystem();
        System.out.println("Initial Available Tickets: " + railway.getAvailableTickets());
        System.out.println("========================================");

        BookingThread b1 = new BookingThread(railway, "Alice", 4);
        CancellationThread c1 = new CancellationThread(railway, "Bob", 2);
        BookingThread b2 = new BookingThread(railway, "Charlie", 6);
        CancellationThread c2 = new CancellationThread(railway, "David", 1);
        BookingThread b3 = new BookingThread(railway, "Eva", 3);

        b1.start();
        c1.start();
        b2.start();
        c2.start();
        b3.start();

        try {
            b1.join();
            c1.join();
            b2.join();
            c2.join();
            b3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("All transactions finished.");
        System.out.println("Final Available Tickets: " + railway.getAvailableTickets());
    }
}
