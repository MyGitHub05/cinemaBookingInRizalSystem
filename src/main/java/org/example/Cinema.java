package org.example;

import java.util.List;

public class Cinema {
    private String name;
    private String location;
    private int numberOfScreen;
    private int seatingCapacityPerScreen;
    private List<Movie> movies;
    private int numrow;
    private int numSeatsPerRow;
    private Seat[][] seats;
    private int ticketPrice;

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getNumberOfScreen() {
        return numberOfScreen;
    }

    public int getSeatingCapacityPerScreen() {
        return seatingCapacityPerScreen;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    Cinema(String name, String location, int numberOfScreen, int seatingCapacityPerScreen, List<Movie> movies, int numrow, int numSeatsPerRow) {
        this.name = name;
        this.location = location;
        this.numberOfScreen = numberOfScreen;
        this.seatingCapacityPerScreen = seatingCapacityPerScreen;
        this.movies = movies;
        this.numrow = numrow;
        this.numSeatsPerRow = numSeatsPerRow;

        //lalagyan mo ng laman yung 2d aray mo
        seats = new Seat[numrow][numSeatsPerRow];
        for (int i = 0; i < numrow; i++) {
            for (int j = 0; j < numSeatsPerRow; j++) {
                seats[i][j] = new Seat(i,j, false);
            }
        }

    }
    public void displayAvailableSeats(){
        for(int i = 0; i<seats.length; i++){
            for(int j =0; j<seats[0].length; j++){
                Seat seat = seats[i][j];
                if (seat.isReserved) {
                    System.out.print(" X ");
                } else {
                    System.out.print(" O ");
                }
            }
            System.out.println();
        }
        System.out.println("------------------------------------------------");
    }


    public void checkSeatIfAvaialble(int row, int seatNumber, boolean isReserved){
        Seat seat  = seats[row][seatNumber];
        seat.isReserved = isReserved;
        if (!seat.isReserved) {
            seat.isReserved = true;
        }
    }

    public int ticketPrice(int row){
        if(seatingCapacityPerScreen <=60){
            ticketPrice = 10;
        }else{
            int frontSeat = seats.length / 2;
            if(row>=frontSeat){
                ticketPrice = 8;
            }else ticketPrice = 10;
        }

        return ticketPrice;
    }
}

