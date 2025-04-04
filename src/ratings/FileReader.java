package ratings;

import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;

public class FileReader {
    public static ArrayList<String> readFile(String filename) {
        try {
            return new ArrayList<>(Files.readAllLines(Paths.get(filename)));
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public static ArrayList<Song> readSongs(String filename){
        ArrayList<Song> songList = new ArrayList<>();
        ArrayList<String> songLines = readFile(filename);
        if(songLines.size() == 0){
            return songList;
        }
        for(String line : songLines){
            ArrayList<String> splitList = new ArrayList<>(Arrays.asList(line.split(",")));

            //songID,artist,title,reviewerID,rating
            String songID = splitList.get(0);
            String artist = splitList.get(1);
            String title = splitList.get(2);
            String reviewerID = splitList.get(3);
            int ratingNum = Integer.parseInt(splitList.get(4));

            Song newSong = new Song(title, artist, songID);
            Rating rating = new Rating(reviewerID, ratingNum);

            if(songList.isEmpty()){
                newSong.addRating(rating);
                songList.add(newSong);
            }
            else{
                for(int i = 0; i < songList.size(); i++){
                    if(newSong.getSongID().equals(songList.get(i).getSongID())){
                        songList.get(i).addRating(rating);
                        break;
                    }
                    else if(i == songList.size()-1){
                        newSong.addRating(rating);
                        songList.add(newSong);
                        break;
                    }
                }
            }
        }
        if(songList.size() != 0){
            return songList;
        }
        else{
            return null;
        }
    }

    public static ArrayList<Movie> readMovies(String filename){
        ArrayList<Movie> movieList = new ArrayList<>();
        ArrayList<String> movieLines = readFile(filename);
        if(movieLines.size() == 0){
            return movieList;
        }
        for(String line : movieLines){
            ArrayList<String> cast = new ArrayList<>();
            ArrayList<String> splitList = new ArrayList<>(Arrays.asList(line.split(",")));

            //movieTitle,castMember0,castMember1,castMember2,etc
            String title = splitList.get(0);
            for(int i = 1; i < splitList.size(); i++){
                String castMember = splitList.get(i);
                cast.add(castMember);
            }
            Movie movie = new Movie(title, cast);
            movieList.add(movie);
        }
        return movieList;
    }

    public static ArrayList<Movie> readMovieRatings(ArrayList<Movie> movies, String filename){
        ArrayList<Movie> returnedMovies = new ArrayList<>();
        ArrayList<String> moviesWithRatings = readFile(filename);
        if(moviesWithRatings.isEmpty() || movies.isEmpty()){
            return new ArrayList<>();
        }

        for(String line : moviesWithRatings){
            ArrayList<String> splitList = new ArrayList<>(Arrays.asList(line.split(",")));

            //title,reviewerId,rating
            String title = splitList.get(0);
            String reviewerID = splitList.get(1);
            int rating = Integer.parseInt(splitList.get(2));

            Rating movieRating = new Rating(reviewerID, rating);

            if(!(movies.isEmpty())){
                for(Movie movie : movies){
                    if(title.equals(movie.getTitle())){
                        if(returnedMovies.isEmpty()){
                            movie.addRating(movieRating);
                            returnedMovies.add(movie);
                            break;
                        }
                        else{
                            for(int i = 0; i < returnedMovies.size(); i++){
                                if(returnedMovies.get(i).getTitle().equals(movie.getTitle())){
                                    returnedMovies.get(i).addRating(movieRating);
                                    break;
                                }
                                else if(i == returnedMovies.size()-1){
                                    movie.addRating(movieRating);
                                    returnedMovies.add(movie);
                                    break;
                                }
                            }
                        }
                        break;
                    }
                }
            }
        }
        return returnedMovies;
    }
}