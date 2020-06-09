package com.lenagasparikova;

public class Main {

    public static void main(String[] args) {

       Theater theater = new Theater("Bystricke", 8, 12);
       theater.getSeats();
      if (theater.reserveSeat("B13")) {
          System.out.println("Please pay now");
      } else {
          System.out.println("Seat already reserved");
      }
        if (theater.reserveSeat("B13")) {
            System.out.println("Please pay now");
        } else {
            System.out.println("Sorry, Seat already reserved");
        }
    }




}
