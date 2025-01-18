import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../services/usere.service';
import { User } from '../models/user.model';

@Component({
  selector: 'app-user-register',
  templateUrl: './user-register.component.html',
  styleUrls: ['./user-register.component.css']
})
export class UserRegisterComponent {
  user: User = {
    username: '',
    password: ''
  };

  constructor(
    private userService: UserService,
    private router: Router
  ) { }

  register(): void {
    this.userService.register(this.user).subscribe(() => {
      this.router.navigate(['/login']);
    });
  }
}