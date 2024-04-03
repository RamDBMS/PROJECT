package com.ram.sms.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ram.sms.model.Student;
import com.ram.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/sms")
public class StudentController {

    @Autowired
    StudentService studentService;             //common object

@GetMapping("/all/{id}")
public ResponseEntity<?> getById(@PathVariable Long id)  {
    try {
        Student student = studentService.getById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String studentJson = objectMapper.writeValueAsString(student);
        return ResponseEntity.ok(studentJson);
    }catch (JsonProcessingException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process student to JSON.");
    } catch (Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve employee.");
    }


}
    @GetMapping("/all")
    public ResponseEntity<String> getallStudent(){
        try {
            List<Student> student = studentService.getFindall();
            if (student.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList().toString());
            }
            ObjectMapper objectMapper = new ObjectMapper();
            String studentJson = objectMapper.writeValueAsString(student);
            return ResponseEntity.ok(studentJson);
        } catch (JsonProcessingException ex) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process student to JSON.");
        } catch (Exception ex) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve student.");
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        try {
            Student student = studentService.deleteById(id);
            if (student == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student data not found");
            }

         /*                      (or)
          try {

                if (id == null || id <= 0) {
                    return ResponseEntity.badRequest().body("Invalid employee ID.");
                }

               studentService.deleteById(id);*/

            return ResponseEntity.ok("StudentId" + id + "Deleted Successfully");
        }  catch (Exception ex) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve employee.");
            }
    }

    @PostMapping("/create")
    public ResponseEntity<String> createAllEmployees(@RequestBody Student student) {
        try {
            // Validate if all fields are filled
            if (student.getName() == null || student.getName().isEmpty()) {
                throw new IllegalArgumentException("Name field must be filled");
            }
            if (student.getGender() == null || student.getGender().isEmpty()) {
                throw new IllegalArgumentException("Name field must be filled");
            }
        Student savedStudent = studentService.saveAllStudent(student);
            return ResponseEntity.status(HttpStatus.CREATED).body("Student added successfully with ID: " + savedStudent.getId());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error occurred: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateAllEmployees(@RequestBody Student student ,@PathVariable Long id){
        try {
            if (student.getId() == null || !student.getId().equals(id)) {
                return ResponseEntity.badRequest().body("Employee ID in the request body doesn't match the ID in the URL.");
            }

            if (student.getName() == null || student.getName().isEmpty() ||
                    student.getGender() == null || student.getGender().isEmpty()) {
                return ResponseEntity.badRequest().body("All fields are compulsory.");
            }
        studentService.updateEmployee(student);
        return ResponseEntity.ok("Student Detail Update Successfully");
    } catch (Exception ex) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update employee.");
        }
}}




