import { bootstrapApplication } from '@angular/platform-browser';
import { provideRouter } from '@angular/router';
import { AppComponent } from './app/app.component';
import { provideHttpClient, HTTP_INTERCEPTORS } from '@angular/common/http';
import { provideAnimations } from '@angular/platform-browser/animations';
import { routes } from './app/app.routes';
import { AuthGuard } from './guards/auth-guard.guard';
import { AuthorizationGuard } from './guards/authorization-guard.guard';
import { AuthService } from './services/auth-service.service';
import {AuthInterceptor} from "./services/auth.interceptor"; // تأكد من المسار الصحيح
// تأكد من المسار الصحيح

bootstrapApplication(AppComponent, {
  providers: [
    provideRouter(routes),
    provideHttpClient(),
    provideAnimations(),
    { provide: AuthService, useClass: AuthService },
    { provide: AuthGuard, useClass: AuthGuard },
    { provide: AuthorizationGuard, useClass: AuthorizationGuard },
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true } // تسجيل المعترض هنا
  ]
}).catch(err => console.error(err));
