import { Routes } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AuthGuard } from '../guards/auth-guard.guard';
import { AuthorizationGuard } from '../guards/authorization-guard.guard';
import { TeacherDashboardComponent } from './dashboard/teacher/teacher-dashboard.component';
import { HomeDashboardComponent } from './dashboard/home/home.dashboard.component';
import { StudentDashbordComponent } from './dashboard/student/student-dashbord.component';
import { ParentDashbordComponent } from './dashboard/parent/parent-dashbord.component';
import {ManagerDashboardComponent} from "./dashboard/manager/manager-dashboard.component";



export const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeDashboardComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'dashboard/teacher/teacher-dashboard', component: TeacherDashboardComponent, canActivate: [AuthGuard, AuthorizationGuard], data: { roles: ['TEACHER'] } },
  { path: 'student-dashboard', component: StudentDashbordComponent, canActivate: [AuthGuard, AuthorizationGuard], data: { roles: ['STUDENT'] } },
  { path: 'parent-dashboard', component: ParentDashbordComponent, canActivate: [AuthGuard, AuthorizationGuard], data: { roles: ['PARENT'] } },
  { path: 'dashboard/manager/manager-dashboard', component: ManagerDashboardComponent, canActivate: [AuthGuard, AuthorizationGuard], data: { roles: ['MANAGER'] }},
  { path: '**', redirectTo: 'home', pathMatch: 'full' },
];
