package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Long> {

    Optional<Course> findByName(String courseName);

    @Query("SELECT courseId FROM Course WHERE name = :courseName")
    Optional<Long> findCourseIdByCourseName(String courseName);

    @Query("select name from Course")
	List<String> findAllCourses();

}
