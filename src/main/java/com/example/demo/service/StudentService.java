package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public Student createStudent(Student student){
        return studentRepository.save(student);
    }
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    public Student getStudentById(Long id){
        return studentRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }
    public Student updateStudent(Long id,Student updatedStudent){
        Student existing =getStudentById(id);
        existing.setName(updatedStudent.getName());
        existing.setEmail(updatedStudent.getEmail());
        existing.setAge(updatedStudent.getAge());
        return studentRepository.save(existing);
    }
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}
