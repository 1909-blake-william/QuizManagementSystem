import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from './models/User';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import {MessageService} from '../app/message.service';
@Injectable({
  providedIn: 'root'
})
export class UserService {
  //Instance Variables
  private userUrl = 'api/user';  // URL to web api
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
  constructor(private http: HttpClient, private messageService: MessageService) { }
  private log(message: string) {
    this.messageService.add(`UserService: ${message}`);
  }
    /** GET user by id. Will 404 if id not found */
    getUser(id: number): Observable<User> {
      const url = `${this.userUrl}/${id}`;
      return this.http.get<User>(url).pipe(
        tap(_ => this.log(`fetched hero id=${id}`)),
        catchError(this.handleError<User>(`getUser id=${id}`))
      );
    }
      /** GET users from the server */
      getUsers (): Observable<User[]> {
        return this.http.get<User[]>(this.userUrl)
          .pipe(
            tap(_ => this.log('fetched heroes')),
            catchError(this.handleError<User[]>('getHeroes', []))
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
  
      //update user results id with quiz results
      updatUser (user: User): Observable<any> {
        return this.http.put(this.userUrl, user, this.httpOptions).pipe(
          tap(_ => this.log(`updated user results id=${user.resultsId}`)),
          catchError(this.handleError<any>('updateUser'))
        );
      }
      /** DELETE: delete a user from the server, perhaps the user is dropped from the revature
   * training
  */
  deleteUser (user: User | number): Observable<User> {
    const id = typeof user === 'number' ? user : user.userId;
    const url = `${this.userUrl}/${id}`;
  
    return this.http.delete<User>(url, this.httpOptions).pipe(
      tap(_ => this.log(`deleted user id=${id}`)),
      catchError(this.handleError<User>('deleteUser'))
    );
  }
}
