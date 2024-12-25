import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { firstValueFrom } from 'rxjs';
firstValueFrom
HttpClient

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private BASE_URL = "http://localhost:8080";

  constructor(private http:HttpClient) { }

  async login(strUsername:string, strPassword:string):Promise<any> {
    const url = `${this.BASE_URL}/auth/login`;
    try {
      // const response = this.http.post<any>(url, {email, password}).toPromise();
      const response = await firstValueFrom(
        this.http.post<any>(url, {strUsername, strPassword})
      );
      return response;
    } catch(error) {
      console.log("Login failed: ", error);
      throw error;
    }
  }

  async register(userData:any, token:string):Promise<any> {
    const url = `${this.BASE_URL}/auth/register`;
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    })
    try {
      // const response = this.http.post<any>(url, {email, password}).toPromise();
      const response = await firstValueFrom(
        this.http.post<any>(url, userData, {headers})
      );
      return response;
    } catch(error) {
      console.log("Register failed: ", error);
      throw error;
    }
  }

  async getUserProfile(token:string):Promise<any> {
    const url = `${this.BASE_URL}/adminuser/get-profile`;
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    })
    try {
      // const response = this.http.post<any>(url, {headers}).toPromise();
      const response = await firstValueFrom(
        this.http.get<any>(url, {headers})
      );
      return response;
    } catch(error) {
      console.log("Get User's profile failed: ", error);
      throw error;
    }
  }

  async getUserByID(userId:string, token:string):Promise<any> {
    const url = `${this.BASE_URL}/admin/get-user/${userId}`;
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    })
    try {
      // const response = this.http.post<any>(url, {email, password}).toPromise();
      const response = await firstValueFrom(
        this.http.get<any>(url, {headers})
      );
      return response;
    } catch(error) {
      console.log("Get User By ID failed: ", error);
      throw error;
    }
  }

  async deleteUserByID(userId:string, token:string):Promise<any> {
    const url = `${this.BASE_URL}/admin/delete-user/${userId}`;
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    })
    try {
      // const response = this.http.post<any>(url, {email, password}).toPromise();
      const response = await firstValueFrom(
        this.http.delete<any>(url, {headers})
      );
      return response;
    } catch(error) {
      console.log("Delete User By ID failed: ", error);
      throw error;
    }
  }

  async updateUserByID(userId:string, userData:any, token:string):Promise<any> {
    const url = `${this.BASE_URL}/admin/update/${userId}`;
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    })
    try {
      // const response = this.http.post<any>(url, {email, password}).toPromise();
      const response = await firstValueFrom(
        this.http.put<any>(url, userData, {headers})
      );
      return response;
    } catch(error) {
      console.log("Delete User By ID failed: ", error);
      throw error;
    }
  }

  /* ---------------------------- AUTHENTICATION METHODS ----------------------------*/
  logOut():void{
    if(typeof localStorage !== 'undefined') {
      localStorage.removeItem('token')
      localStorage.removeItem('role')
    }
  }

  isAuthenticated(): boolean {
    if(typeof localStorage !== 'undefined') {
      const token = localStorage.getItem('token');
      return !!token;
    }
    return false;
  }

  isAdmin(): boolean {
    if(typeof localStorage !== 'undefined') {
      const role = localStorage.getItem('role');
      return role === 'ADMIN';
    }
    return false;
  }

  isUser(): boolean {
    if(typeof localStorage !== 'undefined') {
      const role = localStorage.getItem('role');
      return role === 'USER';
    }
    return false;
  }
}