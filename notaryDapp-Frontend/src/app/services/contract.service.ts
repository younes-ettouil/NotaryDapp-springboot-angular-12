import { TokenStorageService } from './../_services/token-storage.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const baseUrl = 'http://localhost:9999/ms-main/api';
const  headers = new HttpHeaders();
@Injectable({
  providedIn: 'root'
})
export class ContractService {

  constructor(private http:HttpClient,private tokenService:TokenStorageService) {  }

  PostContract(data: any): Observable<any> {
headers.set("Authorization",this.tokenService.getToken())
    return this.http.post(`${baseUrl}/contract`, data,{headers});
  }
  
  GetContractFrom(fromDate): Observable<any> {
    headers.set("Authorization",this.tokenService.getToken())
    return this.http.get(`${baseUrl}/contract/?from=${fromDate}`,{headers});
  }

  GetContractByID(id){
    headers.set("Authorization",this.tokenService.getToken())
    return this.http.get(`${baseUrl}/contract/${id}`,{headers});
  }
}
