package ratings;

public class Rating {
    private String reviewerID;
    private int rating;

    public Rating(String reviewerID, int rating){
        this.reviewerID = reviewerID;
        if(rating < 1 || rating > 5){
            this.rating = -1;
        }
        else{
            this.rating = rating;
        }
    }

    public String getReviewerID(){
        return this.reviewerID;
    }

    public void setReviewerID(String reviewerID){
        this.reviewerID = reviewerID;
    }

    public int getRating(){
        return this.rating;
    }

    public void setRating(int rating){
        if(rating < 1 || rating > 5){
            rating = -1;
        }
        this.rating = rating;
    }
}
