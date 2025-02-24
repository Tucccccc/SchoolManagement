import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { UserService } from '../user.service';
CommonModule
Router
UserService

@Component({
  selector: 'app-user-list',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './user-list.component.html',
  styleUrl: './user-list.component.css'
})
export class UserListComponent implements OnInit{
  users: any[] = [];
  errorMessage: string = ''

  constructor(
    private readonly userService: UserService,
    private readonly router: Router
  ) {}

  ngOnInit(): void {
    this.loadUsers();
  }

  async loadUsers() {
    try {
      const token: any = localStorage.getItem('token');
      const response = await this.userService.getAllUsers(token);

      if(response.intStatusCode == 200 && response.lstUser){ 
        this.users = response.lstUser;
      } else {
        this.showError('No user found');
      }
    } catch(error: any) {
      this.showError(error.message);
    }
  }

  async deleteUser(userId: string) {
    const confirmDelete = confirm("Are you sure to delete this user?");
    if(confirmDelete) {
      try {
        const token: any = localStorage.getItem('token');
        await this.userService.deleteUserByID(userId, token);

        this.loadUsers();
      } catch(error: any) {
        this.showError(error.message);
      }
    }
  }

  navigateToUpdate(userId: string) {
    this.router.navigate(['/update', userId]);
  }

  showError(message: string) {
    this.errorMessage = message;
    setTimeout(() => {
      this.errorMessage = ''; // Clear the error message after the specified duration
    }, 3000);
  }
}