package ratings;

import ratings.datastructures.LinkedListNode;

public class Ratable {
    private String title;
    private LinkedListNode<Rating> ratings;

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void addRating(Rating rating){
        LinkedListNode<Rating> newNode = new LinkedListNode<>(rating, null);

        if (ratings == null) {
            ratings = newNode;
        } else {
            LinkedListNode<Rating> current = ratings;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public LinkedListNode<Rating> getRatings(){
        if(ratings == null){
            return null;
        }
        else{
            return ratings;
        }
    }

    public void setRatings(LinkedListNode<Rating> ratings2){
        ratings = ratings2;
    }

    public double averageRating(){
        if(ratings == null){
            return 0.0;
        }

        double sum = 0.0;
        int count = 0;

        LinkedListNode<Rating> avgRatings = ratings;

        while(avgRatings != null){
            if(avgRatings.getValue() != null && avgRatings.getValue().getRating() != -1){
                if(!(avgRatings.getValue().getRating() < 1 || avgRatings.getValue().getRating() > 5)){
                    sum += avgRatings.getValue().getRating();
                    count++;
                }
            }
            avgRatings = avgRatings.getNext();
        }

        if(count == 0){
            return 0.0;
        }

        return sum / count;
    }

    public void removeRatingByReviewer(Reviewer reviewer){
        ratings.datastructures.LinkedListNode<Rating> now = ratings;
        ratings.datastructures.LinkedListNode<Rating> before = null;


        while(now != null){
            if(now.getValue() != null && now.getValue().getReviewerID().equals(reviewer.getReviewerID())){
                if(before == null){
                    ratings = now.getNext();
                }
                else {
                    before.setNext(now.getNext());
                }
                return;
            }


            before = now;
            now = now.getNext();
        }
    }

    public double bayesianAverageRating(int num, int values){
        if(num < 0 || (values < 1 || values > 5)){
            return 0.0;
        }
        if(ratings == null && num == 0){
            return 0.0;
        }

        double sum = 0.0;
        int count = 0;
        int i = 0;

        LinkedListNode<Rating> avgRatings = ratings;

        while(avgRatings != null){
            if(avgRatings.getValue() != null && avgRatings.getValue().getRating() != -1){
                if(!(avgRatings.getValue().getRating() < 1 || avgRatings.getValue().getRating() > 5)){
                    sum += avgRatings.getValue().getRating();
                    count++;
                }
            }
            avgRatings = avgRatings.getNext();
        }

        while(i<num){
            sum += values;
            i++;
            count++;
        }

        if(count == 0){
            return 0.0;
        }

        return sum / count;
    }
}
