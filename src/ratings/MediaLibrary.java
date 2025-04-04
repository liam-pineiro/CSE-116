package ratings;

import java.util.*;

public class MediaLibrary {
    private ArrayList<Ratable> media;

    public MediaLibrary(){
        this.media = new ArrayList<>();
    }

    public void populateLibrary(String songFile, String movieFile, String movieRatingFile){
        media.addAll(FileReader.readSongs(songFile));
        media.addAll(FileReader.readMovieRatings(FileReader.readMovies(movieFile), movieRatingFile));
    }

    public ArrayList<Ratable> topKRatables(int k){
        ArrayList<Ratable> rankedMedia = rankMedia();
        ArrayList<Ratable> realRankedMedia = new ArrayList<>();

        if(rankedMedia != null || (!rankedMedia.isEmpty())){
            if(k <= rankedMedia.size()){
                for(int i = 0; i < k; i++){
                    realRankedMedia.add(rankedMedia.get(i));
                }
            }
            else if(k > rankedMedia.size()){
                realRankedMedia.addAll(rankedMedia);
            }
            else{
                return new ArrayList<>();
            }
        }
        return realRankedMedia;
    }

    public ArrayList<Ratable> rankMedia(){
        ArrayList<Ratable> rankedMedia = new ArrayList<>();
        ArrayList<Ratable> mediaCopy = new ArrayList<>();
        mediaCopy.addAll(this.media);

        if(!(mediaCopy.isEmpty())){
            while(rankedMedia.size() != this.media.size()){
                Ratable highestRated = mediaCopy.get(0);
                if(mediaCopy.size() != 1){
                    for(int i = 1; i < mediaCopy.size(); i++){
                        if(mediaCopy.get(i).bayesianAverageRating(2, 3) >= highestRated.bayesianAverageRating(2, 3)){
                            highestRated = mediaCopy.get(i);
                        }
                    }
                    rankedMedia.add(highestRated);
                    mediaCopy.remove(highestRated);
                }
                else{
                    rankedMedia.add(highestRated);
                    mediaCopy.remove(highestRated);
                }
            }
        }
        return rankedMedia;
    }
}