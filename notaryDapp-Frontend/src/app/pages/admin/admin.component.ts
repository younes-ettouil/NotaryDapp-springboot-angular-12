import { TokenStorageService } from './../../_services/token-storage.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { AdminService } from './../../services/admin.service';
import { User } from './../../models/user.model';
import { UserService } from 'app/_services/user.service';

import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {
nbr:number;
privateKey=""
UserForm:User={
  name:"",
  username:"",
  password:"",
  role:[
    {
      id:2,
      name:"" 
    }
  ],
  
}
forUpdate=false;
isErr=false;
messageErr="";
users:User[]; 

roles=[];
@ViewChild("content",{static:true}) content:ElementRef;
  constructor(private AdminService:AdminService,
    private modalService:NgbModal,
    private tokenservice:TokenStorageService) { }

  ngOnInit(): void {
    this.allUsers();
    this.roles = this.tokenservice.Roles();

    
  }

  allUsers(){
    this.AdminService.getAll().subscribe(data=>{
      this.users = data;
      this.nbr = this.users.length
    },err=>{
      if(err.status == 403 || err.status == 500){
        this.isErr = true
        this.messageErr = "you are not authorized";
        this.openBackDropCustomClass(this.content);
      }
   
   
    })
  }
  onSaveUser(){
    const data ={
      name:this.UserForm.name,
      username:this.UserForm.username,
      password:this.UserForm.password,
      roles :this.UserForm.role    }
    this.AdminService.create(data).subscribe(resp=>{
      console.log(resp)
      this.allUsers()
      location.reload();
      
    },err=>{
      if(err.status == 403 || err.status == 500){
        this.isErr = true
        this.messageErr = "you are not authorized";
        this.openBackDropCustomClass(this.content);
      }
      
    })
  }
    updateUser(id):void{
      const data ={
        name:this.UserForm.name,
        username:this.UserForm.username,
        password:this.UserForm.password,
        roles :this.UserForm.role 
         } 
        

     this.AdminService.update(id,data).subscribe(resp=>{
       console.log(resp)
     
      this.forUpdate=false;
       this.allUsers()
      },err=>{
        if(err.status == 403 || err.status == 500){
          this.isErr = true
          this.messageErr = "you are not authorized";
          this.openBackDropCustomClass(this.content);
        }
      })
      window.location.reload();
     
  }
  onDeleteUser(id){
    this.AdminService.delete(id).subscribe(resp=>{
      console.log(resp)
      this.allUsers()
      location.reload();
      
    },err=>{
      console.log(err);
      if(err.status == 403 || err.status == 500){
        this.isErr = true
        this.messageErr = "you are not authorized";
        this.openBackDropCustomClass(this.content);
      }
      
    })
  }
resetData(){
  this.UserForm.name="";
  this.UserForm.password="";
  this.UserForm.role[0].id=2;


}
  DetailsUser(username){
    this.AdminService.findByUserName(username).subscribe(resp=>{
      this.forUpdate=true
    this.UserForm.id = resp.id
    this.UserForm.name=resp.name;
    this.UserForm.username=resp.username;
    this.UserForm.password="";
    
      
    },err=>{
      console.log(err);
      if(err.status == 403 || err.status == 500){
        this.isErr = true
        this.messageErr = "you are not authorized";
        this.openBackDropCustomClass(this.content);
      }
      
    })
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
  editewallet(){
    console.log(this.privateKey);
    this.AdminService.editeWallet(this.privateKey).subscribe(res=>{
      console.log(res);
      
    },err=>{
      console.log(err)
    });
  }


}
