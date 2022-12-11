package com.sprngtest.springrest.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprngtest.springrest.dao.CourseDao;
import com.sprngtest.springrest.entities.CourseEntity;
import com.sprngtest.springrest.model.Course;

@Service
public class CourseServiceImp implements CourseService {
	//List<Course> list;
	@Autowired
	private CourseDao courseDao;
	
	public CourseServiceImp() {
		/*
		 * list = new ArrayList<>(); list.add(new Course(1, "Java",
		 * "Java description")); list.add(new Course(2, ".Net", ".Net description"));
		 */
	}

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		ModelMapper modelMapper = new ModelMapper();
		List<Course> lstCourses = new ArrayList<>();
		//List<Course> lstCourses = modelMapper.map(courseDao.findAll(), List<Course>);
		courseDao.findAll().forEach(cd -> {
			Course c = modelMapper.map(cd, Course.class);
			lstCourses.add(c);
		}
		);
		return lstCourses;
	}

	@Override
	public Course getCourse(long courseId) {
		ModelMapper mapper = new ModelMapper();
		Course c = null;
		for(CourseEntity course : courseDao.findAll()) {
			if(course.getId() == courseId) {
				c = mapper.map(course, Course.class);
				break;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course c) {
		ModelMapper mapper = new ModelMapper();
		CourseEntity cEntity = mapper.map(c, CourseEntity.class);
		courseDao.save(cEntity);
		//list.add(c);
		return c;
	}

	@Override
	public void deletCourse(long courseId) {
		// TODO Auto-generated method stub
		/*
		 * for(Course c : list) { if(c.getId() == courseId) { list.remove(c); } }
		 */
		courseDao.deleteById(courseId);
	}

	@Override
	public Course updateCourse(Course c) {
		// TODO Auto-generated method stub
		/*
		 * int i = 0; for(Course c1 : list) { if(c1.getId() == c.getId()) {
		 * list.get(i).setId(c1.getId()); list.get(i).setTitle(c.getTitle());
		 * list.get(i).setDescription(c.getDescription()); } i ++; }
		 */
		ModelMapper mapper = new ModelMapper();
		CourseEntity cEntity = mapper.map(c, CourseEntity.class);
		courseDao.save(cEntity);
		//list.add(c);
		return c;
	}
	
	
	
	

}
