import { Component } from '@angular/core';
import {MatCard, MatCardContent, MatCardHeader, MatCardTitle} from "@angular/material/card";
import {MatDivider} from "@angular/material/divider";

@Component({
  selector: 'app-student-template',
  standalone: true,
  imports: [
    MatCard,
    MatCardTitle,

    MatCardHeader,
    MatDivider,
    MatCardContent
  ],  templateUrl: './student-dashbord.component.html',
  styleUrl: './student-dashbord.component.css'
})
export class StudentDashbordComponent {

}
