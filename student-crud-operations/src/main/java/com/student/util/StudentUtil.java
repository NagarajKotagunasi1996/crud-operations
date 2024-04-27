package com.student.util;

import com.student.dto.StudentDto;
import com.student.entity.Student;

public class StudentUtil {

	public static StudentDto convertEntityToDto(Student student) {

		return StudentDto.builder()
				.id(student.getId())
				.name(student.getName())
				.city(student.getCity())
				.department(student.getDepartment())
				.build();
	}
	
	public static Student convertDtoToEntity(StudentDto studentDto) {

		return Student.builder()
				.id(studentDto.getId())
				.name(studentDto.getName())
				.city(studentDto.getCity())
				.department(studentDto.getDepartment())
				.build();
	}

}
