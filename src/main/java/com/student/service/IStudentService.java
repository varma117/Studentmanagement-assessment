package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.student.model.Student;
@Component
public interface IStudentService {

	public Integer saveStudent(Student student);
	
	public List<Student> getStudents();
	
	public Optional<Student> getStudent(Integer id);
	
	public void deleteStudent(Integer id);
	
	public Student updateStudent(Student student,Integer id);
	
	//public List<Student> getStudentByClass(String className);

	public List<Student> getStudentByClassName(String className);
}
