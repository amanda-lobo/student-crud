package com.generation.test.service;

import com.generation.test.exceptions.InvalidNoteException;
import com.generation.test.exceptions.NotFoundException;
import com.generation.test.model.Students;
import com.generation.test.repository.StudentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.generation.test.utils.Constants.INVALID_NOTE;
import static com.generation.test.utils.Constants.NOT_FOUND_STUDENT;

@Service
public record StudentsService(StudentsRepository studentsRepository) {
    public Students createStudent(Students students) {
        studentGrades(students.getFirstSemesterGrade(), students.getSecondSemesterGrade());
        return studentsRepository.save(students);
    }

    public List<Students> findAllStudents() {
        return studentsRepository.findAll();
    }

    public Students findStudentById(Long studentId) {
        return studentsRepository.findById(studentId).orElseThrow(() -> new NotFoundException(NOT_FOUND_STUDENT));
    }

    public Students updateStudents(Long studentId, Students students) {
        return studentsRepository.findById(studentId)
                .map(update -> {
                    update.setStudentName(students.getStudentName());
                    update.setStudentAge(students.getStudentAge());
                    update.setFirstSemesterGrade(students.getFirstSemesterGrade());
                    update.setSecondSemesterGrade(students.getSecondSemesterGrade());
                    update.setTeachersName(students.getTeachersName());
                    update.setRoomNumber(students.getRoomNumber());

                    return studentsRepository.save(update);
                })
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_STUDENT));
    }

    public void deleteStudent(Long studentId) {
        existsStudents(studentId);
        studentsRepository.deleteById(studentId);
    }

    private void existsStudents(Long studentId) {
        if (!studentsRepository.existsById(studentId)) {
            throw new NotFoundException(NOT_FOUND_STUDENT);
        }
    }

    private void studentGrades(Double firstSemesterGrade, Double secondSemesterGrade) {
        if (firstSemesterGrade > 10.00) {
            throw new InvalidNoteException(INVALID_NOTE);
        }
        if (firstSemesterGrade < 0) {
            throw new InvalidNoteException(INVALID_NOTE);
        }

        if (secondSemesterGrade > 10.00) {
            throw new InvalidNoteException(INVALID_NOTE);
        }

        if (secondSemesterGrade < 0) {
            throw new InvalidNoteException(INVALID_NOTE);
        }
    }
}
