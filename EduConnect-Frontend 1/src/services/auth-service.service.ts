import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable, of } from 'rxjs';
import { tap, delay, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/api/v1/auth'; // تأكد من تطابق هذا مع URL لـ Spring Boot

  public isAuthenticated: boolean = false;
  public username: string | undefined;
  public roles: string[] = [];

  constructor(private http: HttpClient, private router: Router) {}

  login(username: string, password: string): Observable<boolean> {
    return this.http.post<any>(`${this.apiUrl}/authenticate`, { username, password }).pipe(
      tap(response => {
        localStorage.setItem('token', response.token);
        this.isAuthenticated = true;
        this.username = username;
        this.roles = response.roles;  // Assuming roles are returned from the backend
        this.router.navigate([this.getRedirectUrl()]);  // Navigate based on role after login
      }),
      map(response => !!response.token)  // Map response to boolean to indicate success
    );
  }

  private getRedirectUrl(): string {
    if (this.hasRole('TEACHER')) {
      return '/teacher-dashboard';  // Redirect to teacher dashboard
    } else if (this.hasRole('STUDENT')) {
      return '/student-dashboard';  // Redirect to student dashboard
    }
    // Add more cases here based on roles
    return '/home';  // Default path
  }

  logout(): void {
    this.isAuthenticated = false;
    this.username = undefined;
    this.roles = [];
    localStorage.removeItem('token');
    this.router.navigateByUrl('/login');  // Navigate to login page after logout
  }

  hasRole(role: string): boolean {
    return this.roles.includes(role);
  }

  isTokenStored(): boolean {
    return !!localStorage.getItem('token');
  }

  getToken(): string | null {
    return localStorage.getItem('token');
  }
}
