import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from './models/User';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import {MessageService} from '../app/message.service';

@Injectable({
  providedIn: 'root'
})
export class LogInService {
  //Instance Variables
  private userUrl = 'api/login';  // URL to web api
  private serverSideUserUrl = 'http://localhost:8080/QuizManager/api/login';
   
  //Used for requests
  httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  constructor(private http: HttpClient, private messageService: MessageService) { }
  private log(message: string) {
    this.messageService.add(`UserService: ${message}`);
  }
  
    /** POST: add a new user to the server */
    /**Can only be done by an admin */
  createUser (user: User): Observable<User> {

    return this.http.post<User>(this.userUrl, user, this.httpOptions).pipe(
      tap((newUser: User) => this.log(`added user w/ id=${newUser.userId}`)),
      catchError(this.handleError<User>('addUser'))
    );
  }

    getUser(id: number): Observable<User> {
      const url = `${this.userUrl}/${id}`;
      return this.http.get<User>(url).pipe(
        tap(_ => this.log(`fetched hero id=${id}`)),
        catchError(this.handleError<User>(`getUser id=${id}`))
      );
    }
  
    private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
  
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
  
      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);
  
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
  /* GET heroes whose name contains search term */
  /*searchHeroes(term: string): Observable<Hero[]> {
    if (!term.trim()) {
      // if not search term, return empty hero array.
      return of([]);
    }
    return this.http.get<Hero[]>(`${this.heroesUrl}/?name=${term}`).pipe(
      tap(_ => this.log(`found heroes matching "${term}"`)),
      catchError(this.handleError<Hero[]>('searchHeroes', []))
    );
  }*/
}
