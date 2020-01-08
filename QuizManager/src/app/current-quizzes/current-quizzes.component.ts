import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';


@Component({
  selector: 'app-current-quizzes',
  templateUrl: './current-quizzes.component.html',
  styleUrls: ['./current-quizzes.component.css']
})
export class CurrentQuizzesComponent implements OnInit {

  constructor(private http: HttpClient) { }
  
  ngOnInit() {
  }

}
