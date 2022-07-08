package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.model.Student;
import com.student.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/list")
	public String listStudents(Model model) {
		List<Student> studentList = studentService.findAll();
		model.addAttribute("studentList", studentList);
		return "list-students";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		model.addAttribute("mode", "Add");
		return "student-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(Model model, @RequestParam("studentId") long studentId) {
		Student student = studentService.findById(studentId);
		model.addAttribute("student", student);
		model.addAttribute("mode", "Update");
		return "student-form";
	}

	@PostMapping("/save")
	public String saveStudent(@RequestParam("studentId") long studentId, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("courseName") String courseName,
			@RequestParam("country") String country) {
		System.out.println("Inside saveStudent");
		Student student = null;
		if (studentId == 0) {
			student = new Student(firstName, lastName, courseName, country);

		} else {
			student = studentService.findById(studentId);
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setCourseName(courseName);
			student.setCountry(country);
		}
		studentService.save(student);
		return "redirect:list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") long studentId) {
		studentService.delete(studentId);
		return "redirect:list";
	}

}
