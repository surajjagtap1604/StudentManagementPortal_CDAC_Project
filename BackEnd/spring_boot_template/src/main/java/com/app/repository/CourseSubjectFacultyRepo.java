package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.CourseSubjectFaculty;

public interface CourseSubjectFacultyRepo extends JpaRepository<CourseSubjectFaculty, Long>{

	
	@Query("select faculty.id from CourseSubjectFaculty where course_id=:courseId and subject_id=:subjectId")
	Optional<Long> findFacultyId(Long courseId, Long subjectId);
	
	@Query("select distinct(subject.id) from CourseSubjectFaculty where faculty_id=:facultyId and course_id=:courseId")
	Optional<List<Long>> findSubjectListByFacultyId(Long facultyId,Long courseId);

	@Query("select distinct(course.id) from CourseSubjectFaculty where faculty_id=:facultyId")
	Optional<List<Long>> findCourseListByFacultyId(Long facultyId);

	@Query("select distinct(subject.id) from CourseSubjectFaculty where faculty_id=:facultyId")
	Optional<List<Long>> findAllSubjectListByFacultyId(Long facultyId);
	
}



