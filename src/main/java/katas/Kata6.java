package katas;

import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<MovieList> movies = DataUtil.getMovieLists();

        String url = movies.stream().flatMap(movieList -> movieList.getVideos().stream())
                .flatMap(movie1 -> movie1.getBoxarts().stream())
                .reduce((boxArt, boxArt2) ->
                        (boxArt.getHeight() * boxArt.getWidth()) > (boxArt2.getHeight() * boxArt2.getWidth()) ? boxArt : boxArt2)
                .map(boxArt -> boxArt.getUrl()).orElse("");

        System.out.println("Url: " + url);

        return url;
    }
}
