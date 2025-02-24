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
  userData: any = {};
  errorMessage:string = '';

  ngOnInit(): void {
    this.getUserByID();
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
      const {username, role, city} = userDataResponse.user;
      
      this.userData = {username, role, city};
    } catch(error:any) {
      this.showError(error);
    }
  }

  async updateUser() {
    try {
      const token = localStorage.getItem('token');
      if(!token) {
        throw new Error("Token not found");
      }
      console.log(this.userData);
      const res = await this.userService.updateUserByID(this.userId, this.userData, token);
      console.log(res)

      if(res.intStatusCode == 200){
        this.router.navigate(['/users'])
      }else{
        this.showError(res.message)
      }
    } catch(error:any) {
      this.showError(error.message);
    }
  }

  showError(message:string) {
    this.errorMessage = message;
    setTimeout(() => {
      this.errorMessage = '';
    }, 3000);
  };
}