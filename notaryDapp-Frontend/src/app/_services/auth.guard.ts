import { TokenStorageService } from './token-storage.service';
import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private tokenStorage:TokenStorageService,
               private router:Router){}


  canActivate() {
    if (this.tokenStorage.IsLoggedIn()){
     
      return true;
    }
    this.router.navigate(['/signup'])
  }
  
}
