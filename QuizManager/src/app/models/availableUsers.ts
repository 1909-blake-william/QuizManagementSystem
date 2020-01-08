import { InMemoryDbService } from 'angular-in-memory-web-api';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class availableUsers implements InMemoryDbService{
  username: string; 
  email: string;
  firstname: string; 
  lastname: string; 
  password: string; 
  userId: number;
  typeId: number;
  groupId: number; 
  resultsId: number;

createDb(){
  const users = [
  {username: 'mCampbell', email: 'mCampbell@gmail.com', firstname: 'Madeline', lastname: 'Campbell', password: null, 
  userId: 1, typeId: 2, groupId: 1, resultsId: 1},
  {username: 'jCampbell', email: 'jCampbell@gmail.com', firstname: 'Joey', lastname: 'Campbell', password: null, 
  userId: 2, typeId: 2, groupId: 1, resultsId: 2},
  {username: 'kCampbell', email: 'kCampbell@gmail.com', firstname: 'Kathy', lastname: 'Campbell', password: null,
   userId: 3, typeId: 2, groupId: 1, resultsId: 3},
  {username: 'jThomas', email: 'jThomas@gmail.com', firstname: 'John', lastname: 'Thomas', password: null,
   userId: 4, typeId: 2, groupId: 1, resultsId: 4},
  {username: 'gCampbell', email: 'gCampbell@gmail.com', firstname: 'Georgia', lastname: 'Campbell', password: null,
   userId: 5, typeId: 2, groupId: 1, resultsId: 5},
  {username: 'bCampbell', email: 'bCampbell@gmail.com', firstname: 'Blake', lastname: 'Campbell', password: null,
   userId: 6, typeId: 1, groupId: 1, resultsId: 6}
  ];
  return {users};
  }
}