import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
CommonModule
Router
FormsModule
UserService

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  formData: any = {
    strUsername: '',
    strPassword: '',
    strRole: '',
    strCity: ''
  }
  errorMessage: string = '';

  constructor(
    private readonly userService: UserService,
    private readonly router: Router
  ) {}

  async handleSubmit() {
    if(!this.formData.strUsername) {
      this.showError('Please fill in name');
      return;
    }
    if(!this.formData.strPassword) {
      this.showError('Please fill in password');
      return;
    }
    if(!this.formData.strRole) {
      this.showError('Please fill in role');
      return;
    }

    const confirmRegister = confirm('Are you sure to register a new user?');
    if(confirmRegister) {
      try {
        const token: any = localStorage.getItem('token');
        const response = await this.userService.register(this.formData, token);

        if(response.intStatusCode === 200) {
          this.router.navigate(['/users']);
        } else {
          this.showError(response.setStrError);
        }
      } catch(error: any) {
        this.showError(error.message);
      }
    }
  }

  showError(message: string) {
    this.errorMessage = message;
    setTimeout(() => {
      this.errorMessage = ''; // Clear the error message after the specified duration
    }, 3000);
  }
}