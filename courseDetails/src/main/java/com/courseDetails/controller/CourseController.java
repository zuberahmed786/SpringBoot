package com.courseDetails.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.courseDetails.entities.Course;
import com.courseDetails.services.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/saveCourse")
	public void saveCourse(@RequestBody Course course)
	{
		courseService.saveCourse(course);
		
	}

	@GetMapping("/viewCourse")
	public List<Course> fetchCourse()
	{
		List<Course> viewCourse = courseService.viewCourse();
		return viewCourse;
	}
	
	@DeleteMapping("course/{id}")
	
	public void deleteCourse(@PathVariable("id") int id)
	{
		courseService.deleteCourse(id);
	}
	
	
	@PutMapping("/course")
	public void updateCourse(@RequestBody Course course)
	{
		courseService.saveCourse(course);
	}
}
