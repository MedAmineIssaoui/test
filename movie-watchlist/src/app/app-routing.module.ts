import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MovieListComponent } from './movie-list/movie-list.component';
import { MovieDetailComponent } from './movie-detail/movie-detail.component';
import { MovieFormComponent } from './movie-form/movie-form.component';
import { LoginComponent } from './login/login.component';
import { UserRegisterComponent } from './user-register/user-register.component';

const routes: Routes = [
  { path: '', component: MovieListComponent },
  { path: 'movies/new', component: MovieFormComponent },
  { path: 'movies/:id', component: MovieDetailComponent },
  { path: 'register', component: UserRegisterComponent },
  { path: 'login', component: LoginComponent, data: { title: 'Login' } }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }