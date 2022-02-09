import { Router } from '@angular/router';
import { TokenStorageService } from './../../_services/token-storage.service';
import { Component, OnInit, ElementRef } from '@angular/core';
import { Location, LocationStrategy, PathLocationStrategy } from '@angular/common';

@Component({
    selector: 'app-navbar',
    templateUrl: './navbar.component.html',
    styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
    private toggleButton: any;
    private sidebarVisible: boolean;
    addc=false ;

    private roles: string[] = [];
    isLoggedIn = false;
    showAdminBoard = false;
    showModeratorBoard = false;
    username?: string;
    name?:string;

    constructor(public location: Location,
                private element : ElementRef,
                private tokenStorageService:TokenStorageService,
                private router:Router
                ) {this.sidebarVisible = false;}

    ngOnInit() {
        
        const navbar: HTMLElement = this.element.nativeElement;
        this.toggleButton = navbar.getElementsByClassName('navbar-toggler')[0];
        /*-----------------AUTH-------------------- */
        this.isLoggedIn = !!this.tokenStorageService.getToken();

        if (this.isLoggedIn) {
          const user = this.tokenStorageService.getUser();
          this.roles = user.roles;
    
          this.username = user.username.split('@').shift().split('.').join(' ');
          
         
        }
        
        

        // console.log(this.tokenStorageService.getRole());
        
    }
    sidebarOpen() {
        const toggleButton = this.toggleButton;
        const html = document.getElementsByTagName('html')[0];
        // console.log(html);
        // console.log(toggleButton, 'toggle');

        setTimeout(function(){
            toggleButton.classList.add('toggled');
        }, 500);
        html.classList.add('nav-open');

        this.sidebarVisible = true;
    };
    sidebarClose() {
        const html = document.getElementsByTagName('html')[0];
        // console.log(html);
        this.toggleButton.classList.remove('toggled');
        this.sidebarVisible = false;
        html.classList.remove('nav-open');
    };
    sidebarToggle() {
        // const toggleButton = this.toggleButton;
        // const body = document.getElementsByTagName('body')[0];
        if (this.sidebarVisible === false) {
            this.sidebarOpen();
        } else {
            this.sidebarClose();
        }
    };
    
    isHome() {
      var titlee = this.location.prepareExternalUrl(this.location.path());
      if(titlee.charAt(0) === '#'){
          titlee = titlee.slice( 1 );
      }
        if( titlee === '/home' ) {
            return true;
        }
        else {
            return false;
        }
    }
   
 
    // -------LOG-OUT------
    logout(): void {
        
        this.tokenStorageService.signOut();
        window.location.reload()
        window.location.replace("/")
    
      }
    //   addcontrat(event){
    //       this.addc=!this.addc 
    //     localStorage.setItem('addc',`${this.addc}` );
        
    //   }
        
    
    isNotaire():boolean{
        return this.roles[0]==='NOTAIRE'
    }
    isAdmin():boolean{
        return this.roles[0]==='ADMIN'
    }

    
}