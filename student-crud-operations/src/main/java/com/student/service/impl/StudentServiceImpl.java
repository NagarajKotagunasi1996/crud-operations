package com.student.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dto.StudentDto;
import com.student.entity.Student;
import com.student.repo.StudentRepository;
import com.student.service.StudentService;
import com.student.util.StudentUtil;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<StudentDto> getStudents() {

		List<Student> students = studentRepository.findAll();
		return students.stream().map(s -> StudentUtil.convertEntityToDto(s)).collect(Collectors.toList());

	}

	@Override
	public StudentDto createStudent(StudentDto student) {
		Student studentEntity = StudentUtil.convertDtoToEntity(student);
		Student savedStudent = studentRepository.save(studentEntity);
		return StudentUtil.convertEntityToDto(savedStudent);
	}

	@Override
	public StudentDto updateStudent(int studentId, StudentDto studentDto) {

		Optional<Student> student = studentRepository.findById(studentId);

		if (student.isPresent()) {
			Student studentEntity = StudentUtil.convertDtoToEntity(studentDto);
			Student savedStudent = studentRepository.save(studentEntity);
			return StudentUtil.convertEntityToDto(savedStudent);

		}
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentDto getStudent(int studentId) {
		Optional<Student> student = studentRepository.findById(studentId);

		if (student.isPresent()) {

			return StudentUtil.convertEntityToDto(student.get());

		}

		return null;
	}

	@Override
	public void deleteStudent(int studentId) {
		studentRepository.deleteById(studentId);
	}

}
