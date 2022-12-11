package com.sprngtest.springrest.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.sprngtest.springrest.model.Course;
import com.sprngtest.springrest.service.CourseService;


@RestController
public class MyController {
	@Autowired
	CourseService courseService;
	
	@GetMapping("/home")
	public String home() {
		return "Welcome Manoj Wadile";
	}

	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getCourses() {
		return new ResponseEntity<>(courseService.getCourses(), HttpStatus.OK);
	}
	
	@GetMapping("/courses/{courseId}")
	public ResponseEntity<Course> getCourse(@PathVariable String courseId) {
		return new ResponseEntity<>(courseService.getCourse(Long.parseLong(courseId)), HttpStatus.OK);
		
	}
	
	@PostMapping("/courses")
	public ResponseEntity<Course> addCourse(@RequestBody Course c) {
		return new ResponseEntity<>(courseService.addCourse(c), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<String> RemoveCourse(@PathVariable String courseId) {
		 courseService.deletCourse(Long.parseLong(courseId));
		 return new ResponseEntity<>("Course Removed", HttpStatus.ACCEPTED);
		
	}
	
	@PutMapping("/courses")
	public ResponseEntity<Course> updateCourse(@RequestBody Course c) {
		return new ResponseEntity<>(courseService.updateCourse(c), HttpStatus.ACCEPTED);
	}
}
