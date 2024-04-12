import {APP_INITIALIZER, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {KeycloakAngularModule, KeycloakService} from 'keycloak-angular';
import {initializeKeycloak} from "./services/init/keycloak-init.factory";
import {ConfigInitService} from "./services/init/config-init.service";
import {HttpClientModule} from '@angular/common/http';
import {ApiModule} from "./services/api";
import {SidebarComponent} from './components/sidebar/sidebar.component';
import {HeaderComponent} from './components/header/header.component';
import {FooterComponent} from './components/footer/footer.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatListModule} from '@angular/material/list';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {DeviceComponent} from "./pages/device/device.component";
import { HomeComponent } from './pages/home/home.component';
import { DatasetComponent } from './pages/dataset/dataset.component';
import { SubscriptionComponent } from './pages/subscription/subscription.component';
import { NotificationComponent } from './pages/notification/notification.component';
import {MatTableModule} from "@angular/material/table";
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatProgressSpinnerModule} from "@angular/material/progress-spinner";
import {MatInputModule} from "@angular/material/input";
import {MatSortModule} from "@angular/material/sort";

@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent,
    HeaderComponent,
    FooterComponent,
    DeviceComponent,
    HomeComponent,
    DatasetComponent,
    SubscriptionComponent,
    NotificationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    KeycloakAngularModule,
    ApiModule,
    BrowserAnimationsModule,
    MatSidenavModule,
    MatListModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatInputModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatProgressSpinnerModule
  ],
  providers: [
    ConfigInitService,
    {
      provide: APP_INITIALIZER,
      useFactory: initializeKeycloak,
      multi: true,
      deps: [KeycloakService, ConfigInitService],
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
