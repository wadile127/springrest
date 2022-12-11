package com.sprngtest.springrest.service;

import java.util.List;

import com.sprngtest.springrest.model.Course;

public interface CourseService {
	public List<Course> getCourses();
	public Course getCourse(long courseId);
	public Course addCourse(Course c);
	public void deletCourse(long courseId);
	public Course updateCourse(Course c);

}
