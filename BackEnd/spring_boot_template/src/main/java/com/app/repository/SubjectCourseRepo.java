package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.SubjectCourse;

public interface SubjectCourseRepo  extends JpaRepository<SubjectCourse, Long>{
    @Modifying
	@Query("SELECT subjectName FROM SubjectCourse WHERE course_id = :courseId")
	Optional<List<String>> findByCoursesId(Long courseId);


}
