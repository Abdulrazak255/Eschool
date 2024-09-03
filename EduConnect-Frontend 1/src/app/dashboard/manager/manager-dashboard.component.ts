import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ManagerService } from '../../services/manager-services/manager-services.service'; // تأكد من أن المسار صحيح
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatCardModule } from '@angular/material/card';
import { MatTableModule } from '@angular/material/table';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';

@Component({
  selector: 'app-manager-dashboard',
  standalone: true,
  imports: [
    CommonModule,
    MatButtonModule,
    MatIconModule,
    MatCardModule,
    MatTableModule
  ],
  templateUrl: './manager-dashboard.component.html',
  styleUrls: ['./manager-dashboard.component.css']
})
export class ManagerDashboardComponent implements OnInit {
  users: any[] = [];
  classes: any[] = [];
  subjects: any[] = [];
  teachers: any[] = [];
  students: any[] = [];
  parents: any[] = [];

  constructor(
    private managerService: ManagerService,
    private dialog: MatDialog,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadAllData();
  }

  loadAllData() {
    this.managerService.getAllUsers().subscribe((data) => {
      this.users = data;
    });

    this.managerService.getAllClasses().subscribe((data) => {
      this.classes = data;
    });

    this.managerService.getAllSubjects().subscribe((data) => {
      this.subjects = data;
    });

    this.managerService.getAllTeachers().subscribe((data) => {
      this.teachers = data;
    });

    this.managerService.getAllStudents().subscribe((data) => {
      this.students = data;
    });

    this.managerService.getAllParents().subscribe((data) => {
      this.parents = data;
    });
  }

  addUser() {
    // افتح نافذة الحوار لإضافة مستخدم جديد
  }

  editUser(userId: number) {
    // افتح نافذة الحوار لتحرير المستخدم الحالي
  }

  deleteUser(userId: number) {
    // استدعاء الخدمة لحذف المستخدم
    this.managerService.deleteUser(userId).subscribe(() => {
      this.loadAllData();
    });
  }

  // وظائف أخرى مثل إدارة الصفوف، المواد الدراسية، الدرجات، الحضور، إلخ.
}
