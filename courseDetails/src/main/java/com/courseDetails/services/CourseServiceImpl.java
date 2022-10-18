package com.courseDetails.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courseDetails.entities.Course;
import com.courseDetails.repository.CourseRepo;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepo courseRepo;

	@Override
	public void saveCourse(Course course) {
		courseRepo.save(course);
		
	}

	
	@Override
	public List<Course> viewCourse() {
		List<Course> findAll = courseRepo.findAll();
		return findAll;
	}


	@Override
	public void deleteCourse(int id) {
	    courseRepo.deleteById(id);
		
	}
	
	

}
