import { Component } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { NgFor } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    MatToolbarModule,
    MatButtonModule,
    MatCardModule,
    MatIconModule,
    NgFor,
    RouterModule,
  ],
  template: `
    <div class="min-vh-100 bg-light">
      <!-- Hero Section -->
      <header class="bg-primary text-white text-center py-5">
        <h1 class="display-4 font-weight-bold mb-4">Welcome to EduConnect</h1>
        <p class="lead mb-4">Empowering education through comprehensive management</p>
        <button mat-raised-button color="accent" class="btn-lg" [routerLink]="'/register'">Get Started</button>
      </header>

      <!-- Features Section -->
      <section class="py-5">
        <div class="container">
          <h2 class="text-center mb-5">Our Powerful Features</h2>
          <div class="row">
            <div class="col-lg-4 col-md-6 mb-4" *ngFor="let feature of features">
              <mat-card class="h-100 rounded-lg interactive-card">
                <mat-card-header>
                  <mat-icon mat-card-avatar class="text-primary feature-icon">{{ feature.icon }}</mat-icon>
                  <mat-card-title>{{ feature.title }}</mat-card-title>
                </mat-card-header>
                <mat-card-content class="mt-3">
                  <p>{{ feature.description }}</p>
                </mat-card-content>
                <mat-card-actions>
                  <button mat-button color="primary">Learn More</button>
                </mat-card-actions>
              </mat-card>
            </div>
          </div>
        </div>
      </section>
    </div>
  `,
  styles: [
    `
      .min-vh-100 {
        min-height: 100vh;
      }
      .bg-light {
        background-color: #f8f9fa;
      }
      .bg-primary {
        background-color: #007bff !important;
      }
      .text-white {
        color: #ffffff !important;
      }
      .text-primary {
        color: #007bff !important;
      }
      .display-4 {
        font-size: 3.5rem;
      }
      .lead {
        font-size: 1.25rem;
        font-weight: 300;
      }
      .font-weight-bold {
        font-weight: 700 !important;
      }
      .rounded-lg {
        border-radius: 0.375rem;
      }
      .interactive-card {
        transition: all 0.3s ease-in-out;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        height: 100%;
      }
      .interactive-card:hover {
        box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
        transform: translateY(-5px);
      }
      .feature-icon {
        font-size: 48px;
        height: 48px;
        width: 48px;
      }
      .btn-lg {
        padding: 0.5rem 1rem;
        font-size: 1.25rem;
        line-height: 1.5;
        border-radius: 0.3rem;
      }
      .container {
        max-width: 1200px;
        margin: 0 auto;
        padding: 0 15px;
      }
      .row {
        display: flex;
        flex-wrap: wrap;
        margin-right: -15px;
        margin-left: -15px;
      }
      .col-lg-4, .col-md-6 {
        padding-right: 15px;
        padding-left: 15px;
      }
      @media (min-width: 768px) {
        .col-md-6 {
          flex: 0 0 50%;
          max-width: 50%;
        }
      }
      @media (min-width: 992px) {
        .col-lg-4 {
          flex: 0 0 33.333333%;
          max-width: 33.333333%;
        }
      }
    `,
  ],
})
export class HomeComponent {
  features = [
    {
      icon: 'school',
      title: 'School Management',
      description: 'Manage classes, schedules, grades, and subjects with our comprehensive system.',
    },
    {
      icon: 'people',
      title: 'User Management',
      description: 'Efficiently handle students, teachers, parents, librarians, and managers with role-based access.',
    },
    {
      icon: 'menu_book',
      title: 'Library System',
      description: 'Streamline book management, loans, and reservations for your school library.',
    },
    {
      icon: 'event_note',
      title: 'Attendance Tracking',
      description: 'Keep accurate records of student and teacher attendance effortlessly.',
    },
    {
      icon: 'insights',
      title: 'Performance Analytics',
      description: 'Monitor and analyze student performance with advanced grade tracking and reporting.',
    },
    {
      icon: 'archive',
      title: 'Data Archiving',
      description: 'Securely store and easily retrieve historical data for long-term record keeping.',
    },
  ];
}
