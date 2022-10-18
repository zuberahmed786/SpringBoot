package com.courseDetails.services;

import java.util.List;

import com.courseDetails.entities.Course;

public interface CourseService  {
	
	public void saveCourse(Course course);


	public List<Course> viewCourse();


	public void deleteCourse(int id);

}
