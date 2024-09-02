  // app.config.ts
  import { EnvironmentProviders, Provider } from '@angular/core';
  import { provideRouter } from '@angular/router';
  import { provideAnimations } from '@angular/platform-browser/animations';
  import { routes } from './app.routes';

  import { AuthorizationGuard } from '../guards/authorization-guard.guard';
  import {AuthService} from "../services/auth-service.service";
  // تأكد من المسار الصحيح للخدمة

  // كائن لتخزين إعدادات API
  export const ApiConfig = {
    apiUrl: 'http://localhost:8080/api',  // هذا يجب أن يتطابق مع URL الأساسي للواجهة الخلفية
    endpoints: {
      teachers: '/teachers',
      students: '/students',
      classes: '/classes',
      subjects: '/subjects',
      grades: '/grades',
      attendance: '/attendance'
    }
  };

  // تكوين التطبيق باستخدام ApplicationConfig لتحديد المزودين فقط
