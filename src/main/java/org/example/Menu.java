package org.example;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu extends Declaration{

    private List<Movie> movieList;
    private List<Genre> genres;
    ConnectionDatabase cdb = new ConnectionDatabase();


    public void angonoCinema() throws SQLException {
        List<Genre> AngonoMovieGenre = new ArrayList<>();
        List<Movie> AngonoMovies = new ArrayList<>();
        AngonoMovieGenre.add(Genre.ACTION);
        AngonoMovies.add(new Movie("The Shawshank Redemption", "alec", "1hr", AngonoMovieGenre));
        Cinema angono = new Cinema("SM_Angono", "Angono, Rizal", 2, 64, AngonoMovies,8,8);
        showMovies(angono);
        choices(angono);

    }

    public void TaytayCinema() throws SQLException {
        List<Genre> TaytayMovieGenre = new ArrayList<>();
        List<Movie> TaytayMovies = new ArrayList<>();
        TaytayMovieGenre.add(Genre.DRAMA);
        TaytayMovies.add(new Movie("Hachiko", "japanese guy", "1hr", TaytayMovieGenre));
        Cinema taytay = new Cinema("SM_Taytay", "Taytay, Rizal", 2, 64, TaytayMovies,8,16);
        showMovies(taytay);
        choices(taytay);

    }

    public void showMovies(Cinema cinema) {
        List<Movie> movies = cinema.getMovies();
        System.out.println("Movies:");
        for (Movie movie : movies) {
            System.out.println("------------------------------------");
            System.out.println("Title    : " + movie.getTitle());
            System.out.println("Director : " + movie.getDirector());
            System.out.println("Duration : " + movie.getDuration());
            System.out.println("Genre    : " + movie.getGenres());
            System.out.println("------------------------------------");

        }
    }

    public void choices(Cinema cinema) throws SQLException {
        int command = 1;
        do{
            Scanner scan = new Scanner(System.in);
            try{
                System.out.println("Show seats available : [1]");
                System.out.println("Buy ticket           : [2]");
                System.out.println("back                 : [3]");
                System.out.print("-> "); command = scan.nextInt();
            }
            catch (Exception e){
                System.out.println("Please enter a valid command");
            }

            switch (command){
                case 1:
                    showseats(cinema);
                    break;
                case 2:
                    buyTicket(cinema);
                    break;
                case 3:
                    Main main;
                    Main.start();
                    break;
                default:
                    System.out.println("enter valid comand");
            }

        }while(command !=0);
    }


    public void showseats(Cinema cinema) throws SQLException {
        cdb.connect();
        con = cdb.connection();
        String dbTableName = "";
        if(cinema.getName().equals("SM_Angono")){
            dbTableName = "angonocinemaseat";
        }else if(cinema.getName().equals("SM_Taytay")){
            dbTableName = "taytaycinemaseat";
        }
        qry = "select * from " + dbTableName;
        stmnt = con.createStatement();
        rslt = stmnt.executeQuery(qry);
        while(rslt.next()){
            int numrow = rslt.getInt("seatrow");
            int seatNumber = rslt.getInt("seatNumber");
            boolean isReserved = rslt.getBoolean("isReserved");
            cinema.checkSeatIfAvaialble(numrow,seatNumber,isReserved);
        }
        cinema.displayAvailableSeats();

    }


    public void buyTicket(Cinema cinema) throws SQLException {
        Scanner scan = new Scanner(System.in);
        String dbTableName = "";
        System.out.print("Enter row seat    : "); int seatrow = scan.nextInt();
        System.out.print("Enter seat number : "); int seatNumber = scan.nextInt();
        cdb.connect();
        con = cdb.connection();

        if(cinema.getName().equals("SM_Angono")){
            dbTableName = "angonocinemaseat";
        }else if(cinema.getName().equals("SM_Taytay")){
            dbTableName = "taytaycinemaseat";
        }


        qry = "select * from " + dbTableName + " where seatRow = ? and seatNumber = ?";
        pstmnt = con.prepareStatement(qry);
        pstmnt.setInt(1, seatrow);
        pstmnt.setInt(2, seatNumber);
        rslt = pstmnt.executeQuery();
        if(rslt.next()){
            System.out.println("the seat is already reserved \nlease choose another seat");
        }else{

            String command="";
            Scanner scan1 = new Scanner(System.in);
            do{
                try{
                    System.out.println("Ticket price : " +   cinema.ticketPrice(seatrow));
                    System.out.println("Are you sure you want to continue [Y/N]");
                    System.out.print("-> "); command = scan1.nextLine();
                    System.out.println(command);

                }catch (Exception e){
                    System.out.println("Enter valid command");
                }

            }while(!command.equalsIgnoreCase("Y") && !command.equalsIgnoreCase("N"));

            if(command.equalsIgnoreCase("Y")){
                int id = 0;
                qry = "select id from " + dbTableName + " order by id desc limit 1";
                stmnt = con.createStatement();
                rslt = stmnt.executeQuery(qry);
                if(rslt.next()){
                    id = rslt.getInt("id");
                }
                id++;
                qry = "insert into " + dbTableName + " values (?,?,?,?)";
                pstmnt = con.prepareStatement(qry);
                pstmnt.setInt(1, id);
                pstmnt.setInt(2, seatrow);
                pstmnt.setInt(3, seatNumber);
                pstmnt.setBoolean(4,true);
                pstmnt.execute();
                System.out.println("seat succesfuly reserved");

            }else{
                choices(cinema);
            }

        }
    }

}
