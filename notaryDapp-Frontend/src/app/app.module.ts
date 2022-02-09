import { AuthInterceptor } from './_helpers/auth.interceptor';
import { ContractFormComponent } from './components/ContractForm/contract-form.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClient, HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app.routing';

import { AppComponent } from './app.component';
import { NavbarComponent } from './shared/navbar/navbar.component';
import { FooterComponent } from './shared/footer/footer.component';

import { ComponentsModule } from './components/components.module';
import { PagesModule } from './pages/pages.module';
import { IgxAvatarModule } from 'igniteui-angular';

@NgModule({
    declarations: [
        AppComponent,
        NavbarComponent,
        FooterComponent
    ],
    imports: [
        BrowserModule,
        NgbModule,
        FormsModule,
        RouterModule,
        ComponentsModule,
        PagesModule,
        AppRoutingModule,
        HttpClientModule,
        BrowserAnimationsModule,
    
        FormsModule,
        ReactiveFormsModule,
        IgxAvatarModule
    ],
    providers: [{
        provide: HTTP_INTERCEPTORS, 
        useClass: AuthInterceptor, 
        multi: true
      }],
    bootstrap: [AppComponent]
})
export class AppModule {
}
