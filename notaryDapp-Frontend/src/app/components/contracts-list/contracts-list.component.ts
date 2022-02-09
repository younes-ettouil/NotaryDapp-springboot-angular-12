import { TokenStorageService } from "./../../_services/token-storage.service";
import { NgbModal, NgbDateStruct } from "@ng-bootstrap/ng-bootstrap";
import { ContractService } from "./../../services/contract.service";
import { Component, OnInit, ViewChild, ElementRef } from "@angular/core";

@Component({
  selector: "app-contracts-list",
  templateUrl: "./contracts-list.component.html",
  styleUrls: ["./contracts-list.component.scss"],
})
export class ContractsListComponent implements OnInit {
  @ViewChild("content", { static: true }) content: ElementRef;
  isNull=false;
  ListFrom = [];
  contractDetails: any;
  messageErr = "";
  isErr = false;
  model: NgbDateStruct;
  fromDate = "2022-01-03";
  showDetails=false;

  constructor(
    private contractService: ContractService,
    private modalService: NgbModal,
    private tokenservice: TokenStorageService
  ) {}

  ngOnInit(): void {
    this.getContractsFrom(this.fromDate);
  }

  getContractsFrom(date) {
    this.contractService.GetContractFrom(date).subscribe(
      (resp) => {
        this.ListFrom = resp;
        if(this.ListFrom[0]==null){
          this.isNull = true
        }else{this.isNull = false}
        console.log(this.ListFrom);
      },
      (err) => {
        if (err.status == 500) {
          this.isErr = true;
          this.messageErr = "you are not authorized";
          this.openBackDropCustomClass(this.content);
        }
      }
    );
  }

  dtailsContrat(id) {
    console.log(id);
    this.contractService.GetContractByID(id).subscribe(
      (data) => {
        this.contractDetails = data;
        this.showDetails = true;
     
        console.log(this.contractDetails);
      
        
      },
      (err) => {
        if (err.status == 500) {
          this.isErr = true;
          this.messageErr = "you are not authorized";
          this.openBackDropCustomClass(this.content);
        }
      }
    );
  }
  openBackDropCustomClass(content) {
    if (this.isErr == true) {
      this.modalService.open(content, { backdropClass: "light-blue-backdrop" });
    }
  }

  logOut() {
    this.tokenservice.signOut();
    window.location.reload();
    window.location.replace("/");
  }
}
