package katas;

import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.Optional;

/*
    Goal: Retrieve the largest rating using reduce()
    DataSource: DataUtil.getMovies()
    Output: Double
*/
public class Kata5 {
    public static Double execute() {
        List<Movie> movies = DataUtil.getMovies();

       Double ranking = movies.stream()
               .map(movie -> movie.getRating())
               .reduce((rankingMayor, rankingActual) ->{
                return rankingMayor < rankingActual ? rankingActual : rankingMayor;
                })
               .orElse(0D);
        System.out.println("Ranking: " + ranking);
        return ranking;
    }
}
