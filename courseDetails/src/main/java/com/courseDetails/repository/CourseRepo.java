package com.courseDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.courseDetails.entities.Course;

public interface CourseRepo extends JpaRepository<Course,Integer>{

}
