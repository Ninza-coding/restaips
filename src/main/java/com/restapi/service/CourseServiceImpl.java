package com.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.model.Course;
import com.restapi.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Override
	public String upsert(Course course) {
		courseRepository.save(course);
		return "success";
	}

	@Override
	public Course getByID(Integer cid) {
		Optional<Course> findById = courseRepository.findById(cid);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Course> getAllCourse() {

		return courseRepository.findAll();
	}

	@Override
	public String deleteByID(Integer cid) {
		if (courseRepository.existsById(cid)) {
			courseRepository.deleteById(cid);
			return "Delete Success";
		} else {
			return "No record found";
		}
	}
}