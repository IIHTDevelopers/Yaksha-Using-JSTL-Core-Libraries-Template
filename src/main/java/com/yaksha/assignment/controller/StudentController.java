package com.yaksha.assignment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

	@GetMapping("/")
	public String showForm() {
		return "index";
	}

	@GetMapping("/studentList")
	public String showStudentList(Model model) {
		List<String> students = new ArrayList<>();
		students.add("John Doe");
		students.add("Jane Smith");
		students.add("Mary Johnson");
		students.add("James Brown");

		model.addAttribute("students", students);
		return "studentList";
	}
}
