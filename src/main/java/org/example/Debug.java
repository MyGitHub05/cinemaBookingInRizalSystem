package org.example;
//
//
import java.sql.SQLException;

public class Debug extends Declaration{
    public static void main(String[] args){


    }
}
//        ConnectionDatabase cdb = new ConnectionDatabase();
//        cdb.connect();
//        Cinema cinema = new Cinema("dodong",8,8);
//        //cinema.displayAvailableSeats();
//
//        String qry;
//
//
//
//        try{
//            con = cdb.connection();
//            qry = "select * from seatsinangonocinema";
//            stmnt = con.createStatement();
//            rslt = stmnt.executeQuery(qry);
//            while(rslt.next()){
//                int numrow = rslt.getInt("seatrow");
//                int seatNumber = rslt.getInt("seatNumber");
//                cinema.reserveSeat(numrow,seatNumber);
//            }
//            cinema.displayAvailableSeats();
//        }catch (SQLException ex){
//            System.out.println(ex);
//        }
//
//
//    }
//
//    static class Seat {
//        int row;
//        int seatNumber;
//        boolean isReserved;
//
//        public Seat(int row, int seatNumber) {
//            this.row = row;
//            this.seatNumber = seatNumber;
//        }
//    }
//    static class Cinema{
//        private String name;
//        private  Seat[][] seats;
//        public Cinema(String name, int numrow, int numSeatsPerRow){
//            this.name = name;
//
//            //lalagyan mo ng laman yung 2d aray mo
//            seats = new Seat[numrow][numSeatsPerRow];
//            for(int i = 0; i<numrow; i++){
//                for(int j = 0; j<numSeatsPerRow; j++){
//                    seats[i][j] = new Seat(i,j);
//                }
//            }
//
//        }
//
//        public void displayAvailableSeats(){
//            for(int i = 0; i<seats.length; i++){
//                for(int j =0; j<seats[0].length; j++){
//                    Seat seat = seats[i][j];
//                    if (seat.isReserved) {
//                        System.out.print(" O ");
//                    } else {
//                        System.out.print(" V ");
//                    }
//                }
//                System.out.println();
//            }
//        }
//
//        public void reserveSeat(int row, int seatNumber){
//            Seat seat  = seats[row][seatNumber];
//            if (!seat.isReserved) {
//                seat.isReserved = true;
//                System.out.println("Seat " + seat.row + "-" + seat.seatNumber + " reserved successfully!");
//            } else {
//                System.out.println("Seat " + seat.row + "-" + seat.seatNumber + " is already reserved.");
//            }
//
//        }
//    }
//}
