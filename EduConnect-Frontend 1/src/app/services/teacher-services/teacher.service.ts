// teacher.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ApiConfig } from '../../app.config';  // تأكد من استيراد ApiConfig من المسار الصحيح

@Injectable({
  providedIn: 'root'  // يجعل الخدمة قابلة للحقن في كل التطبيق
})
export class TeacherService {
  private apiUrl = ApiConfig.apiUrl;

  constructor(private http: HttpClient) {}

  // دالة لجلب الصفوف التي يدرسها المعلم
  getClassesByTeacher(teacherId: number): Observable<any> {
    return this.http.get(`${this.apiUrl}${ApiConfig.endpoints.teachers}/${teacherId}${ApiConfig.endpoints.classes}`);
  }

  // دالة لجلب الطلاب في الصف
  getStudentsByClass(classId: number): Observable<any> {
    return this.http.get(`${this.apiUrl}${ApiConfig.endpoints.classes}/${classId}${ApiConfig.endpoints.students}`);
  }

  // دالة لجلب معلومات طالب معين
  getStudentById(studentId: number): Observable<any> {
    return this.http.get(`${this.apiUrl}${ApiConfig.endpoints.students}/${studentId}`);
  }

  // دالة لجلب الدرجات لطالب معين
  getGradesByStudent(studentId: number): Observable<any> {
    return this.http.get(`${this.apiUrl}${ApiConfig.endpoints.students}/${studentId}${ApiConfig.endpoints.grades}`);
  }

  // دالة لجلب المواد التي يدرسها المعلم
  getSubjectsByTeacher(teacherId: number): Observable<any> {
    return this.http.get(`${this.apiUrl}${ApiConfig.endpoints.teachers}/${teacherId}${ApiConfig.endpoints.subjects}`);
  }
}
