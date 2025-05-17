package org.example;

import java.time.LocalTime;

public class MainPark {
    public class Attraction {
        private String name;
        private LocalTime startTime;
        private LocalTime endTime;
        private double ticketPrice;

        public Attraction(String name, LocalTime startTime, LocalTime endTime, double ticketPrice) {
            this.name = name;
            this.startTime = startTime;
            this.endTime = endTime;
            this.ticketPrice = ticketPrice;
        }

        public String getName() { return name; }
        public LocalTime getStartTime() { return startTime; }
        public LocalTime getEndTime() { return endTime; }
        public double getTicketPrice() { return ticketPrice; }

        @Override
        public String toString() {
            return "Аттракцион '" + name + "', работает с " + startTime + " до " + endTime + ". Стоимость билета: " + ticketPrice + " руб.";
        }
    }

    public void createParkWithAttractions() {
        Attraction rollerCoaster = new Attraction(
                "Американские горки",
                LocalTime.of(11, 0),
                LocalTime.of(23, 0),
                1000.0
        );

        System.out.println(rollerCoaster);
    }

    public static void main(String[] args) {
        MainPark park = new MainPark();
        park.createParkWithAttractions();
    }
}