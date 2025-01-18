import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { User } from '../models/user.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  user: User = {
    username: '',
    password: ''
  };

  constructor(
    private authService: AuthService,
    private router: Router
  ) { }

  onSubmit(): void {
    this.authService.login(this.user).subscribe(response => {
      if (response) {
        this.router.navigate(['/']);
      } else {
        alert('Invalid credentials');
      }
    });
  }}