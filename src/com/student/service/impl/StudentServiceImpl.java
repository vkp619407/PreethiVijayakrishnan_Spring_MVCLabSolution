package com.student.service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.student.model.Student;
import com.student.service.StudentService;

@Repository
public class StudentServiceImpl implements StudentService {

	private SessionFactory sessionFactory;
	private Session session;

	@Autowired
	public StudentServiceImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
		try {
			this.session = this.sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			this.session = this.sessionFactory.openSession();
		}
	}

	//Method to get all students from Table
	@Override
	public List<Student> findAll() {
		List<Student> studentList = this.session.createQuery("from Student").list();
		return studentList;
	}

	//Method to find student using studentID
	@Override
	public Student findById(long studentId) {
		Student student = this.session.get(Student.class, studentId);
		return student;
	}

	//Method to Save or Update student details in Table
	@Override
	@Transactional
	public void save(Student student) {
		System.out.println("Inside save of Impl");
		Transaction tx = this.session.beginTransaction();
		this.session.saveOrUpdate(student);
		tx.commit();

	}
	
	//Method to delete studentId from Table
	@Override
	@Transactional
	public void delete(long studentId) {
		Transaction tx = this.session.beginTransaction();
		Student student = this.session.get(Student.class, studentId);
		this.session.delete(student);
		tx.commit();
	}

}
