import { ContractsListComponent } from './components/contracts-list/contracts-list.component';

import { NgbdModalContent } from './components/modal/modal.component';
import { RoleGuardGuard } from './_services/role-guard.guard';
import { AuthGuard } from './_services/auth.guard';
import { AdminComponent } from './pages/admin/admin.component';
import { ContractFormComponent } from 'app/components/ContractForm/contract-form.component';
import { NgModule } from '@angular/core';
import { CommonModule, } from '@angular/common';
import { BrowserModule  } from '@angular/platform-browser';
import { Routes, RouterModule } from '@angular/router';

import { ComponentsComponent } from './components/components.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { SignupComponent } from './pages/signup/signup.component';



const routes: Routes =[
    { path: '', redirectTo: 'home', pathMatch: 'full' },
    { path: 'home', 
      component: ComponentsComponent },
    { path: 'user-profile',
      component: ProfileComponent,
      canActivate:[AuthGuard,RoleGuardGuard],
      data:{
      expectedRoles:["NOTAIRE"]
      }
    },
    { path: 'signup',
      component: SignupComponent },
    { path: 'Admin-Dash',
      component: AdminComponent ,
      canActivate:[AuthGuard,RoleGuardGuard],
      data:{
        expectedRoles:["ADMIN"]
      }
    },{
      path:'addcontract',
      component: ContractFormComponent,
      canActivate:[AuthGuard,RoleGuardGuard],
      data:{
      expectedRoles:["NOTAIRE"]
      }

    },{
      path:'contracts',
      component: ContractsListComponent,
      canActivate:[AuthGuard,RoleGuardGuard],
      data:{
      expectedRoles:["NOTAIRE"]
      }

    }
    
    
    

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
