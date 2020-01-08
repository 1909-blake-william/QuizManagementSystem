import { Component, OnInit } from '@angular/core';
import { User} from '../models/User';
import {availableUsers} from '../models/availableUsers';
import {HttpClient} from '@angular/common/http';
import { LogInService } from '../log-in.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  isAdmin: boolean;
  user: User;
  constructor(private http: HttpClient, private authService: LogInService) { }

  ngOnInit() {

  }
  logIn(credentials){
    this.authService.createUser;
  }

  adminLogIn(type: number){
    if (type === 1){
      this.isAdmin = true;
      
    } else {
      this.isAdmin = false;
    }
   
  }

}
