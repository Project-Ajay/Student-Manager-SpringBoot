package com.persauaj.a4_webservice.repository;

import com.persauaj.a4_webservice.beans.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT course FROM COURSE course WHERE course.courseCode = :courseCode")
    Course findByCourseCode(@Param("courseCode") String courseCode);

    @Query("SELECT course FROM COURSE course WHERE course.id = :courseId")
    Course findCourseById(@Param("courseId") Long courseId);


}
