import {Component, OnInit} from '@angular/core';
import {NavigationEnd, Router} from "@angular/router";
import {KeycloakService} from "keycloak-angular";

 enum Route {
  HOME = "/",
  DEVICE = "/device",
  DATASET = "/dataset",
  SUBSCRIPTION = "/subscription",
  NOTIFICATION = "/notification",
}

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {
  readonly route = Route;
  currentRoute: any;

  constructor(private router: Router, private keycloakService: KeycloakService) {
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        // event is an instance of NavigationEnd, get url!
        this.currentRoute = event.urlAfterRedirects;
      }
    });
  }

  ngOnInit(): void {
  }

  public isAuthenticated() {
    return this.keycloakService.isLoggedIn();
  }




}

