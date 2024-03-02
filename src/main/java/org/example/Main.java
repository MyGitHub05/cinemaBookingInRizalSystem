package org.example;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //try lang to kung pano kunin yung value sa loob ng array gamit ang encahnce for loop
        /*
        List<Genre> AngonoMovieGenre = new ArrayList<>();
        List<Movie> AngonoMovies = new ArrayList<>();
        AngonoMovieGenre.add(Genre.ACTION);
        AngonoMovies.add(new Movie("The Shawshank Redemption", "alec", "1hr", AngonoMovieGenre));
        AngonoMovies.add(new Movie("The Shawshank Redemption", "alec", "1hr", AngonoMovieGenre));
        AngonoMovies.add(new Movie("The Shawshank Redemption", "alec", "1hr", AngonoMovieGenre));
        AngonoMovies.add(new Movie("The Shawshank Redemption", "alec", "1hr", AngonoMovieGenre));
        Cinema angono = new Cinema("SM_Angono", "Angono, Rizal", 2, 64, AngonoMovies);

        List<Movie> movies = angono.getMovies();
        for (Movie movie : movies){
            System.out.println("Title : " + movie.getTitle());
        }
*/
        start();

    }
    public static void start(){


        Menu menu = new Menu();
        int command = 1;
        do{
            Scanner scan = new Scanner(System.in);
            try{
                System.out.println("Cinemas here in Rizal:");
                System.out.println("SM Angono  [1]");
                System.out.println("SM Taytay  [2]");
                System.out.print("-> "); command = scan.nextInt();

                switch (command){
                    case 1:
                        menu.angonoCinema();
                        break;
                    case 2:
                        menu.TaytayCinema();
                        break;
                    default:
                        System.out.println("enter valid command");
                }

            }catch (Exception e){
                System.out.println("enter a valid command");
            }

        }while(command !=0);
    }
}