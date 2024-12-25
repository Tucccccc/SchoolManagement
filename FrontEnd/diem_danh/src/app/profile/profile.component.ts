import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
UserService
Router

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent implements OnInit {
  constructor(private readonly userService:UserService, private readonly router: Router){}

  profileInfo: any;
  errorMessage: string = "";
  

  async ngOnInit() {
    try {
      const token = localStorage.getItem('token');
      if(!token) {
        throw new Error("No Token Found");
      }

      this.profileInfo = await this.userService.getUserProfile(token);
    } catch(error:any) {
      this.showError(error.strError);
    }
  }

  // ------------- Parse User's ID to update-user component -------------
  updateProfile(id:string) {
    this.router.navigate(['/update', id]);
  }

  showError(message:string) {
    this.errorMessage = message;
    setTimeout(() => {
      this.errorMessage = '';
    }, 3000);
  };

  hasAdminAuthority(): boolean {
    return this.profileInfo?.user?.authorities?.some((auth: { authority: any; }) => auth.authority === 'ADMIN') || false;
  }
}