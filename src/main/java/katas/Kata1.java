package katas;

import model.Movie;
import util.DataUtil;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: use map() to project an array of videos into an array of {id, title}-pairs
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys")
*/
public class Kata1 {

    public static List<Map<Integer, String>> execute() {
        List<Movie> movies = DataUtil.getMovies();
        List<Map<Integer, String>> moviesNewList = movies.stream()
                                                  .map(movie -> Map.of(movie.getId(), movie.getTitle()))
                                                  .collect(Collectors.toList());

        return moviesNewList;
    }

}
