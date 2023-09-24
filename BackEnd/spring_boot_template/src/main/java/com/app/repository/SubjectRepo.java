package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.Faculty;
import com.app.entity.Student;
import com.app.entity.Subject;

public interface SubjectRepo extends JpaRepository<Subject, Long>  {

	Optional<Subject> findByName(String subjectName);

//	@Modifying
	@Query("select name from Subject where subject_id = :subId")
	Optional<String> findSubjectNameById(Long subId);

    @Query("select subjectId from Subject where name = :subjectName")
	Optional<Long> findSubjectIdBySubjectName(String subjectName);

	
	

}
