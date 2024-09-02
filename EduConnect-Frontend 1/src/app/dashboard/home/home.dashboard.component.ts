import { Component, OnInit } from '@angular/core';
import { MatCardModule } from "@angular/material/card";
import { MatDividerModule } from "@angular/material/divider";
import { AuthService } from "../../../services/auth-service.service";
import { MatListModule } from "@angular/material/list";
import { MatSidenavModule } from "@angular/material/sidenav";
import { RouterLink, RouterOutlet } from "@angular/router";
import { MatMenuModule } from "@angular/material/menu";
import { MatIconModule } from "@angular/material/icon";
import { MatToolbarModule } from "@angular/material/toolbar";
import { MatButtonModule } from "@angular/material/button";
import { NgIf } from "@angular/common";

@Component({
  selector: 'app-admin-template',
  standalone: true,
  imports: [
    MatCardModule,
    MatDividerModule,
    MatListModule,
    MatSidenavModule,
    RouterOutlet,
    MatMenuModule,
    MatIconModule,
    MatToolbarModule,
    MatButtonModule,
    RouterLink,
    NgIf
  ],
  templateUrl: './home.dashboard.component.html',
  styleUrls: ['./home.dashboard.component.css']
})
export class HomeDashboardComponent implements OnInit {
  constructor(public authService: AuthService) { }

  ngOnInit() {}

  logout() {
    this.authService.logout();
  }
}
