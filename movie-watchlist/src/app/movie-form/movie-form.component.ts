import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { MovieService } from '../services/movie.service';
import { Movie } from '../models/movie.model';

@Component({
  selector: 'app-movie-form',
  templateUrl: './movie-form.component.html',
  styleUrls: ['./movie-form.component.css']
})
export class MovieFormComponent {
  movie: Movie = {
    title: '',
    genre: '',
    releaseYear: 0,
    director: '',
    image: '',
    description: '',
    watched: false
  };

  constructor(
    private movieService: MovieService,
    private router: Router
  ) { }

  onSubmit(): void {
    if (this.movie.releaseYear <= 0) {
      alert('Release Year must be a positive number greater than zero.');
      return;
    }
    this.movieService.addMovie(this.movie).subscribe(() => {
      this.router.navigate(['/']);
    });
  }
}