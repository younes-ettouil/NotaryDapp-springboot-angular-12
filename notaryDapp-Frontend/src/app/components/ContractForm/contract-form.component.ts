import { Custumer } from './../../models/custumer.model';

import { Entreprise } from '../../models/entreprise.model';
import { NgbModal, NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';
import { ContractService } from '../../services/contract.service';
import { Contract } from '../../models/contract.model';
import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';

@Component({
  selector: 'app-contract-form',
  templateUrl: './contract-form.component.html',
  styleUrls: ['./contract-form.component.scss']
})

export class ContractFormComponent implements OnInit {
  @ViewChild("content", { static: true }) content: ElementRef;
  simpleSlider = 40;
  doubleSlider = [20, 60];
  state_default: boolean = true;
  focus: any;
  model: NgbDateStruct;
  submitted=false;
  next=false;
  next2=false;
  messageErr="";

 typeClient=1;
  entrprise_seller:Entreprise={
    wallet:"sellerWallet",
      custumerType: "SELLER",
      address:{
        address: "",
        city: "",
        country: ""
      },
      phone: "",
      tradeRegistry: "",
      headOffice: "",
      capital: 0,
      representative:{
        wallet: "",
        custumerType: "",
        address:{
          address:"",
          city: "",
          country: ""
            },
          phone: "",
          fullNAme: "",
          gender: "",
          identityDoc: "CIN",
          identityCode: "",
          nationality: "",
          birthday: "",
          placeOfBirth: ""
      }, 
  }

  entrprise_buyer:Entreprise={
    wallet:"",
      custumerType: "BUYER",
      address:{
        address: "",
        city: "",
        country: ""
      },
      phone: "",
      tradeRegistry: "",
      headOffice: "",
      capital: 0,
      representative:{
        wallet: "",
        custumerType: "",
        address:{
          address:"",
          city: "",
          country: ""
            },
          phone: "",
          fullNAme: "",
          gender: "",
          identityDoc: "CIN",
          identityCode: "",
          nationality: "",
          birthday: "",
          placeOfBirth: ""
      }, 
  }
// ===============================
  custumer_buyer:Custumer={
    wallet: "",
  custumerType: "BUYER",
  address:{
    address: "",
    city: "",
    country: ""
      },
  phone: "",
  fullNAme: "",
  gender: "",
  identityDoc: "CIN",
  identityCode: "",
  nationality: "",
  birthday: "",
  placeOfBirth: ""
  };
  custumer_seller:Custumer={
    wallet: "SellerWallet",
  custumerType: "SELLER",
  address:{
    address: "",
    city: "",
    country: ""
      },
  phone: "",
  fullNAme: "",
  gender: "",
  identityDoc: "CIN",
  identityCode: "",
  nationality: "",
  birthday: "",
  placeOfBirth: ""
  };

  sellersArray = [];buyersArray = [];
  emptyObjects  =  this.custumer_seller ;
  emptyObjectb =  this.custumer_buyer ;

  contract :Contract={
    type:"",
    price:0.00,
    paymentMethod:"",
    sellers:this.sellersArray,
     buyers:this.buyersArray,
     property: {
    type: "",
    conservationNumber: "",
    taxesFree: false,
    surface : 0.00,
    address: {
      address: "",
      city: "",
      country: ""
    }
  },
}

username=""








  constructor(
    private service:ContractService,
    private modalService: NgbModal
    ) { }

  ngOnInit() {
     console.log(this.contract)
   
    ;}
 
  saveContract():void{
      const data = this.contract
      console.log(this.contract);
      console.log(data);
      this.service.PostContract(data)
      .subscribe((res)=>{
        console.log(res);
        this.submitted = true;
        window.location.reload();
        
      },err=>{
        if(err.status == 400){
          this.messageErr="Incorrect Information"
          this.openVerticallyCentered(this.content)
        }
        
      }
      );

  }

  
addRowSeller(TypeSeller:number) {
this.typeClient = TypeSeller;
if(TypeSeller==1){

  this.emptyObjects=this.custumer_seller;
  this.sellersArray.push(Object.assign({}, this.emptyObjects));
}else{
 
  this.emptyObjects=this.entrprise_seller;
  this.sellersArray.push(Object.assign({}, this.emptyObjects));
}

}
  
addRowBuyer(TypeSeller:number) {
this.typeClient = TypeSeller;
if(TypeSeller==1){

  this.emptyObjects=this.custumer_buyer;
  this.buyersArray.push(Object.assign({}, this.emptyObjects));
}else{
 
  this.emptyObjects=this.entrprise_buyer;
  this.buyersArray.push(Object.assign({}, this.emptyObjects));
}

}



  nextStep(event):void{
    this.next = true;
  }

  nextStep2(event):void{
    this.next2 = true;
  }


  backStep(event){
    this.next = false;
  }

  backStep2(event){
    this.next2 = false;
  }
 

  openVerticallyCentered(content) {
    this.modalService.open(content, { centered: true });
  }

 



}
