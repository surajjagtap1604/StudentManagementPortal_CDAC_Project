package com.app.repository;

//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import com.app.entity.DisplayTimetable;
//
//public interface DisplayTimetableRepo  extends JpaRepository<DisplayTimetable, Long> {
//	
////    @Query("SELECT * FROM DisplayTimetable WHERE date <= CURDATE() and course_id = :courseId ORDER BY date DESC LIMIT 1")
////	DisplayTimetable findTimeTableByCourseAndDate(Long courseId);
//	
//	
//	 @Query(value = "SELECT * FROM DisplayTimetable WHERE date <= CURDATE() AND course_id = :courseId ORDER BY date DESC LIMIT 1", nativeQuery = true)
//	    DisplayTimetable findTimeTableByCourseAndDate(Long courseId);
//
//}




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.DisplayTimetable;

public interface DisplayTimetableRepo extends JpaRepository<DisplayTimetable, Long> {
	
    @Query(value = "SELECT * FROM display_timetable WHERE date <= CURDATE() AND course_id = :courseId ORDER BY date DESC LIMIT 1", nativeQuery = true)
    DisplayTimetable findTimeTableByCourseAndDate(Long courseId);

}






