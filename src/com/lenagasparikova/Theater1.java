package com.lenagasparikova;

import java.util.Collections;
import java.util.LinkedList;

public class Theater1 {

    private final String name;
    private LinkedList<Seat> seats;

    public Theater1(String name, int rowNumber, int seatsPerRow) {
        this.name = name;
        int lastRow = 'A' + (rowNumber - 1);
        for (char row = 'A'; row <= rowNumber; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }

    public boolean reserveSeat(String seatNumber) {
        int first = 0;
        int last = seats.size() - 1;
        while (first <= last) {
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

    public boolean binarySearchReserveSeat(String seatNumber) {
        Seat requestSeat = new Seat(seatNumber);
        int foundSeat = Collections.binarySearch(seats, requestSeat, null);
        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        }
        System.out.println(seatNumber + " not found");
        return false;
    }

//    public boolean reserveSeat(String seatNumber) {
//        Seat requestSeat = null;
//        for (Seat seat : seats) {
//            if (seat.getSeatNumber().equals(seatNumber)) {
//                requestSeat = seat;
//                break;
//            }
//        }
//        if (requestSeat == null) {
//            System.out.println("Seat " + seatNumber + " not found");
//            return false;
//        }
//        return requestSeat.reserve();
//    }

    public void getSeats() {
        for (Seat seat : seats) {
            System.out.println(seat.getSeatNumber());
        }
    }


    private class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        private boolean reserve() {
            if (!reserved) {
                reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            }
            return false;
        }

        private boolean cancel() {
            if (reserved) {
                reserved = false;
                System.out.println("Seat " + seatNumber + " cancelled");
                return true;
            }
            return false;
        }

        public String getSeatNumber() {
            return seatNumber;
        }
    }

}
