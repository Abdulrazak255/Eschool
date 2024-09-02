import { Component } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatIconModule } from '@angular/material/icon';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import {MatCard} from "@angular/material/card";

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    MatIconModule,
    MatCheckboxModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatCard,
  ],
  template: `
    <div class="min-vh-100 d-flex align-items-center justify-content-center bg-light">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-8 col-md-10">
            <mat-card class="p-5 rounded-lg shadow-lg">
              <h2 class="text-center mb-5 text-primary font-weight-bold">Register for EduConnect</h2>
              <form [formGroup]="registerForm" (ngSubmit)="onSubmit()">
                <div class="row mb-4">
                  <div class="col-md-6">
                    <mat-form-field appearance="outline" class="w-100">
                      <mat-label>First Name</mat-label>
                      <input matInput formControlName="firstName" type="text" placeholder="Enter your first name" required>
                    </mat-form-field>
                  </div>
                  <div class="col-md-6">
                    <mat-form-field appearance="outline" class="w-100">
                      <mat-label>Last Name</mat-label>
                      <input matInput formControlName="lastName" type="text" placeholder="Enter your last name" required>
                    </mat-form-field>
                  </div>
                </div>
                <div class="row mb-4">
                  <div class="col-md-6">
                    <mat-form-field appearance="outline" class="w-100">
                      <mat-label>Email</mat-label>
                      <input matInput formControlName="email" type="email" placeholder="Enter your email" required>
                    </mat-form-field>
                  </div>
                  <div class="col-md-6">
                    <mat-form-field appearance="outline" class="w-100">
                      <mat-label>Country</mat-label>
                      <input matInput formControlName="country" type="text" placeholder="Enter your country" required>
                    </mat-form-field>
                  </div>
                </div>
                <div class="row mb-4">
                  <div class="col-md-6">
                    <mat-form-field appearance="outline" class="w-100">
                      <mat-label>Password</mat-label>
                      <input matInput formControlName="password" type="password" placeholder="Create a password" required>
                    </mat-form-field>
                  </div>
                  <div class="col-md-6">
                    <mat-form-field appearance="outline" class="w-100">
                      <mat-label>Confirm Password</mat-label>
                      <input matInput formControlName="confirmPassword" type="password" placeholder="Confirm your password" required>
                    </mat-form-field>
                  </div>
                </div>
                <div class="row mb-4">
                  <div class="col">
                    <mat-form-field appearance="outline" class="w-100">
                      <mat-label>Date of Birth</mat-label>
                      <input matInput [matDatepicker]="picker" formControlName="dob" placeholder="Select your date of birth" required>
                      <mat-datepicker-toggle matSuffix [for]="picker"></mat-datepicker-toggle>
                      <mat-datepicker #picker></mat-datepicker>
                    </mat-form-field>
                  </div>
                </div>
                <div class="text-center mb-4">
                  <mat-checkbox formControlName="agreeTerms">
                    I agree to the <a href="#" class="text-primary">terms and conditions</a>
                  </mat-checkbox>
                </div>
                <div class="text-center">
                  <button mat-raised-button color="primary" class="btn-lg w-100">Submit</button>
                </div>
              </form>
            </mat-card>
          </div>
        </div>
      </div>
    </div>
  `,
  styles: [
    `
      .bg-light {
        background-color: #f8f9fa;
      }
      .min-vh-100 {
        min-height: 100vh;
      }
      .rounded-lg {
        border-radius: 0.375rem;
      }
      .shadow-lg {
        box-shadow: 0 10px 15px -3px rgba(0, 0, 0, 0.1),
        0 4px 6px -2px rgba(0, 0, 0, 0.05);
      }
      .text-primary {
        color: #007bff;
      }
      .text-center {
        text-align: center;
      }
      .btn-lg {
        padding: 0.75rem 1.25rem;
        font-size: 1.25rem;
        line-height: 1.5;
        border-radius: 0.3rem;
      }
      .container {
        max-width: 960px;
      }
      .row {
        margin-right: -15px;
        margin-left: -15px;
      }
      .col-md-6 {
        padding-right: 15px;
        padding-left: 15px;
      }
      mat-card {
        transition: box-shadow 0.3s ease-in-out;
      }
      mat-card:hover {
        box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
      }
    `,
  ],
})
export class RegisterComponent {
  registerForm: FormGroup;

  constructor(private fb: FormBuilder) {
    this.registerForm = this.fb.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      country: ['', Validators.required],
      password: ['', Validators.required],
      confirmPassword: ['', Validators.required],
      dob: ['', Validators.required],
      agreeTerms: [false, Validators.requiredTrue],
    });
  }

  onSubmit() {
    if (this.registerForm.valid) {
      console.log('Register form values:', this.registerForm.value);
    }
  }
}
