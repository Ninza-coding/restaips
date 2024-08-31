package com.restapi.service;

import java.util.List;

import com.restapi.model.Course;

public interface CourseService {

	public String upsert(Course couse);

	public Course getByID(Integer cid);

	public List<Course> getAllCourse();

	public String deleteByID(Integer cid);
}
