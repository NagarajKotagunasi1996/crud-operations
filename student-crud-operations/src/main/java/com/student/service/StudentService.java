package com.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.dto.StudentDto;

@Service
public interface StudentService {

	List<StudentDto> getStudents();

	StudentDto createStudent(StudentDto student);

	StudentDto updateStudent(int studentId, StudentDto student);

	StudentDto getStudent(int studentId);

	void deleteStudent(int studentId);

}
