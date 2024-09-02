import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule } from '@angular/material/button';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import {MatLine} from "@angular/material/core";
import {TeacherService} from "../../services/teacher-services/teacher.service";

@Component({
  selector: 'app-teacher-dashboard',
  standalone: true,
  imports: [
    CommonModule,
    HttpClientModule,
    MatButtonModule,
    MatMenuModule,
    MatIconModule,
    MatListModule,
    MatLine
  ],
  templateUrl: './teacher-dashboard.component.html',
  styleUrls: ['./teacher-dashboard.component.css']
})
export class TeacherDashboardComponent implements OnInit {
  teacherId: number = 1; // Example teacher ID
  classes: any[] = [];
  students: any[] = [];
  selectedStudent: any = null;
  grades: any[] = [];
  showClasses: boolean = false;
  showStudents: boolean = false;
  showStudentInfo: boolean = false;
  subjects: any[] = [];
  showSubjects: boolean = false;

  constructor(private teacherService: TeacherService) {}

  ngOnInit(): void {
    // Display classes on initial load
    this.getClasses();
  }

  getClasses() {
    this.teacherService.getClassesByTeacher(this.teacherId).subscribe((data: any) => {
      this.classes = data;
      this.showClasses = true;
      this.showStudents = false;
      this.showStudentInfo = false;
    });
  }

  getStudents(classId: number) {
    this.teacherService.getStudentsByClass(classId).subscribe((data: any) => {
      this.students = data;
      this.showStudents = true;
      this.showClasses = false;
      this.showStudentInfo = false;
    });
  }

  getStudentInfo(studentId: number) {
    this.teacherService.getStudentById(studentId).subscribe((studentData: any) => {
      this.selectedStudent = studentData;
      this.teacherService.getGradesByStudent(studentId).subscribe((gradesData: any) => {
        this.grades = gradesData;
        this.showStudentInfo = true;
        this.showStudents = false;
        this.showClasses = false;
      });
    });
  }

  getSubjects() {
    this.teacherService.getSubjectsByTeacher(this.teacherId).subscribe((data: any) => {
      this.subjects = data;
      this.showSubjects = true;
      this.showClasses = false;
      this.showStudents = false;
      this.showStudentInfo = false;
    });
  }
}
