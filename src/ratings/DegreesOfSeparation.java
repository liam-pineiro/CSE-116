package ratings;

import ratings.datastructures.*;
import java.util.*;

public class DegreesOfSeparation {

    private ArrayList<Movie> movies;

    public DegreesOfSeparation(ArrayList<Movie> movies){
        this.movies = movies;
    }

    public int degreesOfSeparation(String castMember1, String castMember2){
        Graph<String> movieCastGraph = new Graph<>();

        if(!(movies.isEmpty())){
            for (Movie movie : movies) {
                ArrayList<String> cast = movie.getCast();

                for (String actor1 : cast) {
                    for (String actor2 : cast) {
                        if (!actor1.equals(actor2)) {
                            movieCastGraph.addEdge(actor1, actor2);
                        }
                    }
                }
            }
        }
        else{
            return -1;
        }

        HashMap<String, ArrayList<String>> adjacencyList = movieCastGraph.getAdjacencyList();

        //One of actors not in graph
        if(!adjacencyList.containsKey(castMember1) || !adjacencyList.containsKey(castMember2)) {
            return -1;
        }
        //Same actor
        else if(castMember1.equals(castMember2)) {
            return 0;
        }

        LinkedList<String> list = new LinkedList<>();
        HashMap<String, Boolean> visited = new HashMap<>();
        HashMap<String, Integer> distance = new HashMap<>();

        for (String actor : adjacencyList.keySet()) {
            visited.put(actor, false);
        }

        list.add(castMember1);
        visited.put(castMember1, true);
        distance.put(castMember1, 0);

        while (!list.isEmpty()) {
            String currentActor = list.poll();

            for (String neighbor : adjacencyList.getOrDefault(currentActor, new ArrayList<>())) {
                if (!visited.get(neighbor)) {
                    visited.put(neighbor, true);
                    distance.put(neighbor, distance.get(currentActor) + 1);
                    list.add(neighbor);

                    if (neighbor.equals(castMember2)) {
                        return distance.get(neighbor);
                    }
                }
            }
        }

        //If actors not connected
        return -1;
    }
}
