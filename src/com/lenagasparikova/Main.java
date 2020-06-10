package com.lenagasparikova;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Theater1 theater = new Theater1("Bystricke", 8, 12);
        List<Theater1.Seat> list = new ArrayList<>(theater.getSeats());
        printList(list);

        System.out.println("===============================");
        List<Theater1.Seat> reverseList = new ArrayList<>(list);
        Collections.reverse(reverseList);
        printList(reverseList);


        if (theater.reserveSeat("D12")) {
            System.out.println("Please pay for D12 ticket");
        } else {
            System.out.println("D12 already reserved");
        }
        if (theater.reserveSeat("B13")) {
            System.out.println("Please pay for B13 ticket");
        } else {
            System.out.println("Seat not found or already reserved");
        }
        if (theater.reserveSeat("D12")) {
            System.out.println("Please pay for D12 ticket");
        } else {
            System.out.println("D12 already reserved");
        }

//        List<Theater.Seat> copySeats = new ArrayList<>(theater.seats);
//        List<Theater.Seat> newList = new ArrayList<>(copySeats);
//        Collections.copy(newList, copySeats);
//        printList(newList);

//        List<Theater.Seat> original = new ArrayList<>(theater.seats);
//        List<Theater.Seat> copy = new ArrayList<>(original);
//        Collections.copy(copy, original);
//        printList(copy);

//        printList(copySeats);
//
//        copySeats.get(2).reserve();
//        if (theater.reserveSeat("A3")) {
//            System.out.println("Please pay now");
//        } else {
//            System.out.println("Seat already reserved");
//        }
//
//        Theater.Seat minSeat = Collections.min(copySeats);
//        System.out.println(minSeat.getSeatNumber());
//        Theater.Seat maxSeat = Collections.max(copySeats);
//        System.out.println(maxSeat.getSeatNumber());

//        Collections.shuffle(copySeats);
//        printList(copySeats);
//        System.out.println("============");
//        sortList(copySeats);
//        printList(copySeats);
//        System.out.println("============");
//        Collections.shuffle(copySeats);
//        printList(copySeats);
//        System.out.println("============");
//        Collections.sort(copySeats);
//        printList(copySeats);

    }

    public static void printList(List<Theater1.Seat> list) {
        for (Theater1.Seat seat : list) {
            System.out.print("Seat " + seat.getSeatNumber() + ", Price: " + seat.getPrice());
        }
        System.out.println("================");
    }

    public static void sortList(List<? extends Theater1.Seat> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }
}
