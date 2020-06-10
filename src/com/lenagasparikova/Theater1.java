package com.lenagasparikova;

import java.util.*;

public class Theater1 {

    private final String name;
    public List<Seat> seats = new ArrayList<>(); // changed access modifier for exercise purposes

    public Theater1(String name, int rowNumber, int seatsPerRow) {
        this.name = name;
        int lastRow = 'A' + (rowNumber - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                double price = 12;
                if ((row < 'D') && (seatNum >= 4 && seatNum <= 9)) {
                    price = 14.00;
                } else if ((row > 'F') || (seatNum < 4 || seatNum > 9)) {
                    price = 7.00;
                }
                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }

//    public boolean reserveSeat(String seatNumber) {
//        int first = 0;
//        int last = seats.size() - 1;
//        while (first <= last) {
//            int mid = (first + last) / 2;
//            Seat midVal = seats.get(mid);
//            int comparison = midVal.getSeatNumber().compareTo(seatNumber);
//            if (comparison < 0) {
//                first = mid + 1;
//            } else if (comparison > 0) {
//                last = mid - 1;
//            } else {
//                return seats.get(mid).reserve();
//            }
//
//        }
//        System.out.println(seatNumber + " not found");
//        return false;
//    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestSeat = new Seat(seatNumber, 0);
        int foundSeat = Collections.binarySearch(seats, requestSeat, null);
        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        }
        System.out.println(seatNumber + " not found");
        return false;
    }

    public boolean findAndReserveSeat(String seatNumber) {
        Seat requestSeat = new Seat(seatNumber, 0);
        int foundSeat = Collections.binarySearch(seats, requestSeat);
        if (foundSeat > 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println(seatNumber + " not found");
            return false;
        }
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

    public Collection<Seat> getSeats() {
        return seats;
    }

    public class Seat implements Comparable<Seat> {        // made public for exercise purposes
        private final String seatNumber;
        private double price;
        private boolean reserved = false;

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
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

        public double getPrice() {
            return price;
        }
    }
}
