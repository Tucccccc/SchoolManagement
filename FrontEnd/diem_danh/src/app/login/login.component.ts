import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
UserService
Router

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  constructor(
    private readonly userService:UserService,
    private router:Router
  ){}

  email:string = '';
  password:string = '';
  errorMessage:string = '';

  async handleSubmit() {
    if(!this.email || !this.password) {
      this.showError("Email and Password is required");
      return;
    }

    try {
      const response = await this.userService.login(this.email, this.password);
      console.log(response);
      if(response.intStatusCode == 200) {
        localStorage.setItem('token', response.strToken)
        localStorage.setItem('role', response.strRoles)
        this.router.navigate(['/profile'])
      } else {
        this.showError(response.strError);
      }
    } catch(error:any) {
      this.showError(error.strError);
    }
  }

  showError(message:string) {
    this.errorMessage = message;
    setTimeout(() => {
      this.errorMessage = '';
    }, 3000);
  };
}