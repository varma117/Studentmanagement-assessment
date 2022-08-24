package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.exceptionhandling.ResourceNotFoundException;
import com.student.model.Student;
import com.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements IStudentService {
	
@Autowired
StudentRepository studentRepository;

@Override
public Integer saveStudent(Student student) {
	Student saveStudent = studentRepository.save(student);
	return saveStudent.getId();
}

@Override
public List<Student> getStudents() {
	
	return studentRepository.findAll();
}

@Override
public Optional<Student> getStudent(Integer id) {
	
	return studentRepository.findById(id);
}

@Override
public void deleteStudent(Integer id) {
	studentRepository.deleteById(id);
	
}

@Override
public Student updateStudent(Student student, Integer id) {
	Student existingStudent = studentRepository.findById(id).orElseThrow(
		() -> new ResourceNotFoundException("Student", "id", id));
	
	existingStudent.setFirstName(student.getFirstName());
	existingStudent.setLastName(student.getLastName());
	existingStudent.setSubject(student.getSubject());
	existingStudent.setDateofbirth(student.getDateofbirth());
	existingStudent.setClassName(student.getClassName());
	
	studentRepository.save(existingStudent);
	return existingStudent;
}

@Override
public List<Student> getStudentByClassName(String className) {
	
	return studentRepository.getStudentByClassName(className);
}
	
}
