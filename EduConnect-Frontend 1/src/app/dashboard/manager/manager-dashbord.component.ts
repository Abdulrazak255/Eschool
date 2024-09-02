import { Component } from '@angular/core';
import {MatCard, MatCardContent, MatCardHeader, MatCardTitle} from "@angular/material/card";
import {MatDivider} from "@angular/material/divider";

@Component({
  selector: 'app-manager-template',
  standalone: true,
  imports: [
    MatCard,
    MatCardTitle,

    MatCardHeader,
    MatDivider,
    MatCardContent
  ],  templateUrl: './manager-dashbord.component.html',
  styleUrl: './manager-dashbord.component.css'
})
export class ManagerDashbordComponent {

}
