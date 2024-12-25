import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
HttpClient

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  title = 'Demo';
  greeting = {'id': 'XXX', 'content': 'Hello World'};

  // constructor(private http: HttpClient) {
  //   http.get('resource').subscribe(data => this.greeting = data);
  // }
}