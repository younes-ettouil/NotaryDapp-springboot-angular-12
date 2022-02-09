
import { ContractFormComponent } from 'app/components/ContractForm/contract-form.component';
import { ComponentsModule } from './../components/components.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { ProfileComponent } from './profile/profile.component';
import { SignupComponent } from './signup/signup.component';
import { AdminComponent } from './admin/admin.component';



@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        NgbModule,
        ComponentsModule,
        ReactiveFormsModule,
     
        
    ],
    declarations: [
        SignupComponent,
        ProfileComponent,
        ContractFormComponent,
        AdminComponent,        
        
    ]
})
export class PagesModule { }
