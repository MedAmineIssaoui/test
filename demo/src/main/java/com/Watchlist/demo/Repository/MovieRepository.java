package com.Watchlist.demo.Repository;

import com.Watchlist.demo.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByWatched(boolean watched);
    List<Movie> findByTitleContaining(String title);
    List<Movie> findByGenreContaining(String genre);
    List<Movie> findByDirectorContaining(String director);
}