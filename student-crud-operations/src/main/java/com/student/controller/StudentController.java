package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.dto.StudentDto;
import com.student.service.StudentService;

@RestController
@RequestMapping("/studentservice")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("students")
	public ResponseEntity<Object> getStudents() {

		List<StudentDto> students = studentService.getStudents();
		if (!students.isEmpty() && students != null) {
			return new ResponseEntity<Object>(students, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>("Students are not available", HttpStatus.NO_CONTENT);
		}

	}

	@GetMapping("students/{id}")
	public ResponseEntity<Object> getStudent(@PathVariable("id") Integer id) {
		StudentDto student = studentService.getStudent(id);
		if (student != null) {
			return new ResponseEntity<Object>(student, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>("Student is not available for given id", HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("students")
	public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto student) {
		StudentDto b = studentService.createStudent(student);
		return new ResponseEntity<StudentDto>(b, HttpStatus.CREATED);

	}

	@PutMapping("students/{id}")
	public ResponseEntity<Object> updateStudent(@PathVariable("id") int id, @RequestBody StudentDto student) {

		StudentDto s = studentService.updateStudent(id, student);
		if (s != null) {
			return new ResponseEntity<Object>(s, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Object>("Student is not available update", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("students/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") int id) {
		studentService.deleteStudent(id);
		return new ResponseEntity<String>("student deleted successfully", HttpStatus.OK);

	}

}
