import { TokenStorageService } from './../../_services/token-storage.service';
import { NgbModal, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { ContractService } from './../../services/contract.service';

import { Component, OnInit, ViewEncapsulation, ViewChild, ElementRef } from '@angular/core';

@Component({
    selector: 'app-profile',
    templateUrl: './profile.component.html',
    styleUrls: ['./profile.component.scss'],
    encapsulation: ViewEncapsulation.None,
    styles: [`
    .dark-modal .modal-content {
      background-color: #292b2c;
      color: white;
    }
    .dark-modal .close {
      color: white;
    }
    .light-blue-backdrop {
      background-color: #b9b9b9;
    }
  `]
})

export class ProfileComponent implements OnInit {

    @ViewChild("content",{static:true}) content:ElementRef;
    addContract='false';
    isLoggedIn=false
    from="2022-01-03";
    messageErr="";
    isErr=false;

    username="";
    constructor( private modalService: NgbModal,
        private ContractService:ContractService,
        private tokenservice :TokenStorageService) { }

    ngOnInit() { 

      this.isLoggedIn = !!this.tokenservice.getToken();

      if (this.isLoggedIn) {
        const user = this.tokenservice.getUser();
        
  
        this.username = user.username.split('@').shift().split('.').join(' ');

       
      }

      
        this.addContract = localStorage.getItem('addc');
    }

    openBackDropCustomClass(content) {
        if (this.isErr==true) {
            this.modalService.open(content, {backdropClass: 'light-blue-backdrop'});
        }
        
      }

      logOut(){
        this.tokenservice.signOut()   ;
        window.location.reload()
        window.location.replace("/")
      }

}
