import { Component } from '@angular/core';
import {MatCard, MatCardContent, MatCardHeader, MatCardTitle} from "@angular/material/card";
import {MatDivider} from "@angular/material/divider";

@Component({
  selector: 'app-parent-template',
  standalone: true,
  imports: [
    MatCard,
    MatCardHeader,
    MatDivider,
    MatCardTitle,
    MatCardContent
  ],  templateUrl: './parent-dashbord.component.html',
  styleUrl: './parent-dashbord.component.css'
})
export class ParentDashbordComponent {

}
