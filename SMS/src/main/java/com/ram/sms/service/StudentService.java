package com.ram.sms.service;

import com.ram.sms.model.Student;
import com.ram.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public List<Student> getFindall() {
        return studentRepository.findAll();
    }

    public Student deleteById(Long id) {
         studentRepository.deleteById(id);
        return null;
    }

    public Student saveAllStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    public void updateEmployee(Student student) {
        studentRepository.save(student);
    }

    public Student getById(Long id) {
       return studentRepository.findById(id).orElse(null);

    }
}
