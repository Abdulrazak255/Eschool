package be.brussel.school.service;

import be.brussel.school.model.Grade;
import be.brussel.school.repository.GradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;

    @Override
    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    @Override
    public Optional<Grade> getGradeById(Long id) {
        return gradeRepository.findById(id);
    }

    @Override
    public Grade saveGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    @Override
    public Grade updateGrade(Long id, Grade grade) {
        if (gradeRepository.existsById(id)) {
            grade.setId(id);
            return gradeRepository.save(grade);
        }
        return null;
    }

    @Override
    public void deleteGrade(Long id) {
        gradeRepository.deleteById(id);
    }

    @Override
    public List<Grade> getGradesByStudentId(Long studentId) {
        return gradeRepository.findGradeByStudent_Id(studentId);
    }

    @Override
    public List<Grade> getGradesBySubjectId(Long subjectId) {
        return gradeRepository.findGradeBySubject_Id(subjectId);
    }

    @Override
    public List<Grade> getGradesByTeacherId(Long teacherId) {
        return gradeRepository.findGradeByTeacher_Id(teacherId);
    }
}
