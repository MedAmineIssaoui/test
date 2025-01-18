package com.Watchlist.demo.Service;

import com.Watchlist.demo.Entity.Movie;
import com.Watchlist.demo.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie updateMovie(Long id, Movie movieDetails) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));
        movie.setTitle(movieDetails.getTitle());
        movie.setGenre(movieDetails.getGenre());
        movie.setReleaseYear(movieDetails.getReleaseYear());
        movie.setDirector(movieDetails.getDirector());
        movie.setImage(movieDetails.getImage());
        movie.setDescription(movieDetails.getDescription());
        movie.setWatched(movieDetails.isWatched());
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    public List<Movie> filterMoviesByWatched(boolean watched) {
        return movieRepository.findByWatched(watched);
    }

    public List<Movie> searchMoviesByTitle(String title) {
        return movieRepository.findByTitleContaining(title);
    }

    public List<Movie> searchMoviesByGenre(String genre) {
        return movieRepository.findByGenreContaining(genre);
    }

    public List<Movie> searchMoviesByDirector(String director) {
        return movieRepository.findByDirectorContaining(director);
    }
}
