package theatreChallenge;

public class Main {

    public static void main(String[] args) {

        Theatre theatre = new Theatre("Richard", 10, 100);
        theatre.printSeatMap();

        bookSeat(theatre, 'A', 3);
        bookSeat(theatre, 'A', 3);
        bookSeat(theatre, 'B', 1);
        bookSeat(theatre, 'B', 11);
        bookSeat(theatre, 'M', 1);

        bookSeats(theatre, 4, 'B', 3, 10);
        bookSeats(theatre, 6, 'B', 'C', 3, 10);
        bookSeats(theatre, 4, 'B', 1, 10);
        bookSeats(theatre, 4, 'B', 'C', 1, 10);
        bookSeats(theatre, 1, 'B', 'C', 1, 10);
        bookSeats(theatre, 4, 'M', 'Z', 1, 10);
        bookSeats(theatre, 10, 'A', 'E', 1, 10);

        theatre.printSeatMap();
    }

    private static void bookSeat(Theatre theatre, char row, int seatNo) {
        if (theatre.reserveSeat(row, seatNo)) {
            System.out.println("Congratulations! Your reserved seat is " + row + seatNo);
        } else {
            System.out.println("Sorry! Unable to reserve " + row + seatNo);
        }
    }

    private static void bookSeats(Theatre theatre, int tickets, char minRow, int minSeat, int maxSeat) {
        bookSeats(theatre, tickets, minRow, minRow, minSeat, maxSeat);
    }

    private static void bookSeats(Theatre theatre, int tickets, char minRow, char maxRow,
                                  int minSeat, int maxSeat) {
        var seats = theatre.reserveSeats(tickets, minRow, maxRow, minSeat, maxSeat);
        if (seats != null) {
            System.out.println("Congratulations! Your reserved seats are " + seats);
            theatre.printSeatMap();
        } else {
            System.out.println("Sorry! Not enough free seats in rows: "
                    + minRow + " - " + maxRow);
        }
    }
}
