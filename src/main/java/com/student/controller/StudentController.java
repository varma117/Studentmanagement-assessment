package com.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Student;
import com.student.service.IStudentService;

@RestController
//@RequestMapping("/student")
public class StudentController {
 
	@Autowired
	IStudentService studentService;
	
	@PostMapping("/savestudent")
	public Integer saveStudent(@RequestBody Student student) {
		Integer Id = studentService.saveStudent(student);
		return Id;
	}
	@GetMapping("/getstudent/{id}")
	public Optional<Student> getStudent(@PathVariable Integer id ){
		Optional<Student> student = studentService.getStudent(id);
		return student;
	}
	
	
	@GetMapping("/getstudentbyclass/{className}")
	public List<Student> getStudentByclass(@PathVariable String className){
		List<Student> student = studentService.getStudentByClassName(className);
		//return studentService.getStudentByClassName(className);
		return student;
	}
	
	
	@GetMapping("/getall")
	public List<Student> getStudents() {
		return studentService.getStudents();
	}
	
	
	@DeleteMapping("/deletestudent/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable Integer id){
		ResponseEntity<Student> responseEntiti = new ResponseEntity<>(HttpStatus.OK);
		try {
			studentService.deleteStudent(id);
		}
		catch(Exception e) {
			e.printStackTrace();
			responseEntiti = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return responseEntiti;
	}
	
	
	@PutMapping("/updatestudent/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") Integer id,@RequestBody Student student){
		return new ResponseEntity<Student>(studentService.updateStudent(student, id),HttpStatus.OK);
	}
	
	}
	

