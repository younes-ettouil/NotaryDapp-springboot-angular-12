import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { TokenStorageService } from './../../_services/token-storage.service';
import { AuthService } from './../../_services/auth.service';
import { Component, OnInit } from '@angular/core';
import { isAwaitExpression } from 'typescript';

@Component({
    selector: 'app-signup',
    templateUrl: './signup.component.html',
    styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {
    test : Date = new Date();
    focus;
    focus1;
    
    form: any = {
        username: null,
        password: null
      };
      isLoggedIn = false;
      isLoginFailed = false;
      errorMessage = '';
      roles: string[] = [];

    constructor(private authservice:AuthService,
       private tokenStorage: TokenStorageService,
       private router:Router,
       private modalService:NgbModal,
       private http:HttpClient) { }

    ngOnInit() {

      
      
        if (this.tokenStorage.getToken()) {
            this.isLoggedIn = true;
             this.roles = this.tokenStorage.getUser().roles;
      
          }
    }
    onSubmit(): void {
       
        var formData: any = new FormData();
        formData.set("username", this.form.username);
        formData.set("password", this.form.password);
    
    
        this.authservice.login(formData).subscribe(data=>{
          
          this.tokenStorage.saveToken(data.access_token);
          this.tokenStorage.saveUser(data);
          
          this.isLoginFailed = false;
          this.isLoggedIn = true;

        
          
          this.roles = this.tokenStorage.getUser().roles;

          if(this.roles[0]==='NOTAIRE') {  
             window.location.reload()
            window.location.replace("/user-profile")}
          else if(this.roles[0]==='ADMIN') {
            window.location.reload()
            window.location.replace("/Admin-Dash")
          }
       
        },err=>{
          
          
          this.errorMessage = "Login / Password incorrect";
          
          console.log(this.errorMessage );
          
          this.isLoginFailed = true;
          window.location.reload()
         
        })

      }
    
      reloadPage(): void {
        window.location.reload();
      }

      openVerticallyCentered(content) {
        this.modalService.open(content, { centered: true });
      }
      delay(ms: number) {
        return new Promise( resolve => setTimeout(resolve, ms) );
    }
}
