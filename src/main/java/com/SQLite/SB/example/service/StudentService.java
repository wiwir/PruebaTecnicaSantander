package com.SQLite.SB.example.service;

import com.SQLite.SB.example.entity.Student;
import com.SQLite.SB.example.repository.StudentRepository;

import dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> buscarEstudiantePorNombre (String nombre){
        try {
            return studentRepository.findByName(nombre);
        }catch (Exception e){
            throw e;
        }
    }

    public List<Student> listarEstudiantePorLetra (String nombre){
        try {
            return studentRepository.listarEstudiantePorLetra(nombre);
        }catch (Exception e){
            throw e;
        }
    }

    public void eliminarEstudianteDesdeId3 (){
        try {
            List<Student> estudiantes = studentRepository.findAll();
            List<Student> estudiantesEliminar = estudiantes.stream().filter(v -> v.getId() > 3).collect(Collectors.toList());
            estudiantesEliminar.forEach(v -> studentRepository.delete(v));
        }catch (Exception e){
            throw e;
        }
    }

    public List<StudentDto> listarEstudiante (){
        try {
          List<Student> estudiantes = studentRepository.findAll();
          List<StudentDto> estudianteNombreEmail = new ArrayList<>();

          estudiantes.forEach(v -> {
              StudentDto estudianteDto = new StudentDto();
              estudianteDto.setNombre(v.getName());
              estudianteDto.setEmail(v.getEmail());
              estudianteNombreEmail.add(estudianteDto);
          });

          return  estudianteNombreEmail;

        }catch (Exception e){
            throw e;
        }
    }


    @Transactional
    public String createStudent(Student student){
        try {
            if (!studentRepository.existsByEmail(student.getEmail())){
                student.setId(null == studentRepository.findMaxId()? 0 : studentRepository.findMaxId() + 1);
                studentRepository.save(student);
                return "Student record created successfully.";
            }else {
                return "Student already exists in the database.";
            }
        }catch (Exception e){
            throw e;
        }
    }

    public List<Student> readStudents(){
        return studentRepository.findAll();
    }
    
  

    @Transactional
    public String updateStudent(Student student){
        if (studentRepository.existsByEmail(student.getEmail())){
            try {
                List<Student> students = studentRepository.findByEmail(student.getEmail());
                students.stream().forEach(s -> {
                    Student studentToBeUpdate = studentRepository.findById(s.getId()).get();
                    studentToBeUpdate.setName(student.getName());
                    studentToBeUpdate.setEmail(student.getEmail());
                    studentRepository.save(studentToBeUpdate);
                });
                return "Student record updated.";
            }catch (Exception e){
                throw e;
            }
        }else {
            return "Student does not exists in the database.";
        }
    }

}
