import { TokenStorageService } from './token-storage.service';
import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RoleGuardGuard implements CanActivate {
  
constructor(private route:Router,
            private TokenStorageService:TokenStorageService){}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      
      return this.isAuthorized(route);
    
  }
  public  isAuthorized(route:ActivatedRouteSnapshot):boolean{
    const roles=[this.TokenStorageService.getRole()];
    
    
    const expectedRoles = route.data.expectedRoles;
    const roleMatchers = roles.findIndex(role=>expectedRoles.indexOf(role)!== -1);
    if ((roleMatchers>=0)) {
       return  true
    }else{
      console.log(roles);
      this.route.navigate(["/signup"])
      return false
    }
  
    
  }
}
