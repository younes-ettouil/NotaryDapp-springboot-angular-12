import { TokenStorageService } from './../_services/token-storage.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { User } from 'app/models/user.model';

const baseUrl = "http://localhost:8081/auth";
const headers = new HttpHeaders()
@Injectable({
  providedIn: 'root'
})
export class AdminService {
  constructor(private http: HttpClient,private Tokenservice:TokenStorageService) { }

  getAll(): Observable<User[]> {
    headers.set("Authorization",this.Tokenservice.getToken())
    return this.http.get<User[]>(baseUrl+"/users",{headers});
  }

  create(data: any): Observable<any> {
    headers.set("Authorization",this.Tokenservice.getToken())
    return this.http.post(baseUrl+"/user", data,{headers});
  }

  update(id: any, data: any): Observable<any> {
    headers.set("Authorization",this.Tokenservice.getToken())
    return this.http.put(`${baseUrl}/user/${id}`,data,{headers});
  }

  delete(id: any): Observable<any> {
    headers.set("Authorization",this.Tokenservice.getToken())
    return this.http.delete(`${baseUrl}/user/${id}`,{headers});
  }

  editeWallet(privateKey:string):Observable<any> {
    headers.set("Authorization",this.Tokenservice.getToken())
    return this.http.get(`http://localhost:9999/ms-eth/eth/private-key/${privateKey}`  ,{headers})
  }


  findByUserName(username: any): Observable<any> {
    headers.set("Authorization",this.Tokenservice.getToken())
    return this.http.get(`${baseUrl}/users/${username}`,{headers});
  }
}
