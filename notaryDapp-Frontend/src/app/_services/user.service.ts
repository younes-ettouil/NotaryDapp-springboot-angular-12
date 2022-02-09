import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';


// const API_URL = 'http://localhost:9999/api/';
const API_URL2 = 'http://localhost:8081/auth/';

const headers = new HttpHeaders();
const TOKEN_HEADER_KEY = 'Authorization'; 


@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }


  getAdminBoard(token: string | string[]): Observable<any> {
    const headers = new HttpHeaders().set(TOKEN_HEADER_KEY,token);
    return this.http.get(API_URL2 + 'users',{headers});
  }

}
