package com.Watchlist.demo.Controller;

import com.Watchlist.demo.Entity.Movie;
import com.Watchlist.demo.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movieDetails) {
        return movieService.updateMovie(id, movieDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }

    @GetMapping("/filter")
    public List<Movie> filterMoviesByWatched(@RequestParam boolean watched) {
        return movieService.filterMoviesByWatched(watched);
    }

    @GetMapping("/search")
    public List<Movie> searchMovies(@RequestParam String title, @RequestParam String genre, @RequestParam String director) {
        if (!title.isEmpty()) {
            return movieService.searchMoviesByTitle(title);
        } else if (!genre.isEmpty()) {
            return movieService.searchMoviesByGenre(genre);
        } else if (!director.isEmpty()) {
            return movieService.searchMoviesByDirector(director);
        } else {
            return movieService.getAllMovies();
        }
    }
}