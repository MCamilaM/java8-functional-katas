package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        List<Map> newListMovies = movieLists.stream().flatMap(movieList -> movieList.getVideos().stream())
                .map(movie ->
                        Map.of("id ", movie.getId(),
                                "title ", movie.getTitle(),
                                "time ", movie.getInterestingMoments().stream()
                                        .filter(time -> time.getType().equals("Middle"))
                                        .map(interestingMoment -> interestingMoment.getTime()),
                                "url ", movie.getBoxarts().stream().reduce((boxArt, boxArt2) ->
                                                (boxArt.getHeight() * boxArt.getWidth()) < (boxArt2.getHeight() * boxArt2.getWidth()) ? boxArt : boxArt2)
                                        .map(boxArt -> boxArt.getUrl()))).collect(Collectors.toList());
        System.out.println(newListMovies);
        return newListMovies;
    }
}
