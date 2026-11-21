package theatreChallenge;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Theatre {

    class Seat implements Comparable<Seat> {

        private String seatNum;
        private boolean reserved;

        public Seat(char rowChar, int seatNo) {
            this.seatNum = "%c%03d".formatted(rowChar, seatNo).toUpperCase();
        }

        public String getSeatNum() {
            return seatNum;
        }

        public boolean isReserved() {
            return reserved;
        }

        public void setReserved(boolean reserved) {
            this.reserved = reserved;
        }

        @Override
        public String toString() {
            return seatNum;
        }


        @Override
        public int compareTo(Seat o) {

            return Comparator.comparing(Seat::getSeatNum).compare(this,o);
        }
    }

    private String theatreName;
    private int seatsInRow;
    private NavigableSet<Seat> seats;

    public Theatre(String theatreName, int rows, int totalSeats) {
        this.theatreName = theatreName;
        this.seatsInRow = totalSeats / rows;

        seats = new TreeSet<>();
        for (int i = 0; i < totalSeats; i++) {
            char rowChar = (char) (i / seatsInRow + (int) 'A');
            int seatInRow = i % seatsInRow + 1;
            seats.add(new Seat(rowChar, seatInRow));
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public int getSeatsInRow() {
        return seatsInRow;
    }

    public void printSeatMap() {
        String separatorLine = "-".repeat(90);
        System.out.printf("%1$s%n%2$s Seat Map%n%1$s%n", separatorLine, theatreName);

        int index = 0;
        for (Seat s : seats) {
            System.out.printf("%-8s%s",
                    s.seatNum + ((s.reserved) ? "(*)" : ""),
                    ((index++ + 1) % seatsInRow == 0) ? "\n" : "");
        }
        System.out.println(separatorLine);
    }


    public boolean reserveSeat(char row, int seat) {
        Seat seatObj = new Seat(row,seat);
        Seat found = seats.ceiling(seatObj);
        if(found==null || found.compareTo(seatObj)!=0||found.isReserved())return false;

        found.setReserved(true);
        return true;
    }


    public Set<Seat> reserveSeats(int reservationCount, char minRow, char maxRow,
                                  int minSeat, int maxSeat) {
        int count =0;
        TreeSet<Seat> reservedSeats = new TreeSet<>();
        Set<Seat> targetSeats = seats.subSet(
                        new Seat(minRow, 1), true,
                        new Seat(maxRow, seatsInRow), true)
                .stream()
                .filter(s -> {
                    int n = Integer.parseInt(s.getSeatNum().substring(1));
                    return !s.isReserved() && n >= minSeat && n <= maxSeat;
                })
                .collect(Collectors.toCollection(TreeSet::new));
        if(targetSeats.size() < reservationCount) return  null;
        for (Seat s: targetSeats){
            if(s.isReserved())continue;
            s.setReserved(true);
            reservedSeats.add(s);
            count++;
            if(count>=reservationCount)break;
        }
        return reservedSeats;



    }
}
