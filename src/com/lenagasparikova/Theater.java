package com.lenagasparikova;

import java.util.*;

public class Theater {
    private final String theaterName;
    public List<Seat> seats = new ArrayList<>(); // declared public for the exercise purpose

    public Theater(String theaterName, int numberRows, int seatsPerRow) {
        this.theaterName = theaterName;
        int lastRow = 'A' + (numberRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; ++seatNum) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }

    public boolean reserveSeat(String seatNumber) {
        int first = 0;
        int last = seats.size() - 1;
        while (first <= last) {
//            System.out.println("*");
            int mid = (first + last) / 2;
            Seat midVal = seats.get(mid);
            int comparison = midVal.getSeatNumber().compareTo(seatNumber);
            if (comparison < 0) {
                first = mid + 1;
            } else if (comparison > 0) {
                last = mid - 1;
            } else {
                return seats.get(mid).reserve();
            }
        }
        System.out.println(seatNumber + " not found");
        return false;
    }

    public boolean binarySearchReserveNumber(String seatNumber) {
        Seat requestSeat = new Seat(seatNumber);
        int foundSeat = Collections.binarySearch(seats, requestSeat, null);
        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println(seatNumber + " not found");
            return false;
        }
    }

//    public boolean reserveSeat(String seatNumber) {
//        Seat requestSeat = new Seat(seatNumber);
//        int foundSeat = Collections.binarySearch(seats, requestSeat, null);
//        if (foundSeat >= 0) {
//            return seats.get(foundSeat).reserve();
//        } else {
//            System.out.println("No such seat exists");
//            return false;
//        }
//    }

    //    for (Seat seat : seats) {
//            System.out.println(".");
//            if (seat.getSeatNumber().equals(seatNumber)) {
//                requestSeat = seat;
//                break;
//            }
//        }
//        if (requestSeat == null) {
//            System.out.println("There is no seat " + seatNumber);
//            return false;
//        }
//        return requestSeat.reserve();
//    }
//
    public void getSeats() {
        for (Seat seat : seats) {
            System.out.println(seat.getSeatNumber());
        }
    }

    public class Seat implements Comparable<Seat> { // declared public for the exercise purpose only!
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public boolean reserve() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            } else {
                return false;
            }
        }

        public boolean cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled");
                return true;
            }
            return false;
        }
    }

}
