import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { UserService } from '../user.service';
import { ActivatedRoute, Router } from '@angular/router';
Router
ActivatedRoute
UserService
CommonModule

@Component({
  selector: 'app-update-user',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './update-user.component.html',
  styleUrl: './update-user.component.css'
})
export class UpdateUserComponent implements OnInit{
  constructor(private readonly userService:UserService,
    private readonly router: Router,
    private readonly route: ActivatedRoute
  ){}

  userId: any;
  userData: any;
  errorMessage:string = '';

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  // ------------- Get ID from profile -------------
  async getUserByID() {
    this.userId = this.route.snapshot.paramMap.get('id');
    const token = localStorage.getItem('token');

    if(!this.userId || !token) {
      this.showError("User ID or Token is required");
      return;
    }

    try {
      let userDataResponse = await this.userService.getUserByID(this.userId, token);
      const {username, roles} = userDataResponse.user;
      this.userData = {username, roles};
    } catch(error:any) {
      this.showError(error);
    }
  }

  async updateUser() {
    const confirmDialog = confirm("Are you sure you wanna update this user")
  }

  showError(message:string) {
    this.errorMessage = message;
    setTimeout(() => {
      this.errorMessage = '';
    }, 3000);
  };
}