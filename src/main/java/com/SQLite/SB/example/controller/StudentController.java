package com.SQLite.SB.example.controller;

import com.SQLite.SB.example.entity.Student;
import com.SQLite.SB.example.service.StudentService;

import dto.StudentDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/example")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @ApiOperation("INFO")
    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info(){
        return "The application is up...";
    }

    @ApiOperation("Busca los estudiantes por nombre")
    @RequestMapping( method = RequestMethod.GET,value = "/buscarEstudiantePorNombre/{name}")
    public List<Student> buscarEstudiantePorNombre(@PathVariable(value = "name") String name){
        return studentService.buscarEstudiantePorNombre(name);
    }

    @ApiOperation("lista los estudiantes por la primera letra")
    @RequestMapping(method = RequestMethod.GET,value = "/listarEstudiantePorConcidencia/{name}")
    public List<Student> listarEstudiante(@PathVariable(value = "name") String name){
        return studentService.listarEstudiantePorLetra(name);
    }

    @ApiOperation("Elimina los estudiantes con un id  > 3")
    @RequestMapping( method = RequestMethod.DELETE,value = "/eliminarEstudianteDesdeId3")
    public void eliminarEstudiante(){
        studentService.eliminarEstudianteDesdeId3();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/listarEstudiante")
    public List<StudentDto> listarEstudiante(){
        return studentService.listarEstudiante();
    }

    @RequestMapping(value = "createstudent", method = RequestMethod.POST)
    public String createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @RequestMapping(value = "readstudents", method = RequestMethod.GET)
    public List<Student> readStudents(){
        return studentService.readStudents();
    }

    @RequestMapping(value = "updatestudent", method = RequestMethod.PUT)
    public String updateStudet(@RequestBody Student student){
        return studentService.updateStudent(student);
    }
    
 
}
