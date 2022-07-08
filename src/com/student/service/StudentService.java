package com.student.service;

import java.util.List;

import com.student.model.Student;

public interface StudentService {
	
	public List<Student> findAll();
	
	public Student findById(long studentId);
	
	public void save(Student student);
	
	public void delete(long studentId);

}
