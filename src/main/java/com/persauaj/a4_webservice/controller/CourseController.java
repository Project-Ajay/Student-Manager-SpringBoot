package com.persauaj.a4_webservice.controller;

import com.persauaj.a4_webservice.beans.Course;
import com.persauaj.a4_webservice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/course")
public class CourseController {

    private CourseRepository courseRepo;
    public CourseController(CourseRepository courseRepository){
        this.courseRepo = courseRepository;
    }

    @GetMapping // get all courses
    public List<Course> getCourses(){
        return courseRepo.findAll();
    }



    //Get by Course ID
    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id){
        return courseRepo.findCourseById(id);
    }

    //Add a course
    @PostMapping(consumes = "application/json")
    public String postCourse(@RequestBody Course course){
        return "http://localhost:8080/course/" + course.getCourseCode();
    }

    @PutMapping("/{id}")
    public String putCourse(@RequestBody Course course,@PathVariable Long id){
        course.setId(id);
        courseRepo.save(course);
        return course.getCourseName() + " was updated";


    }


    //Delete course by ID
    @DeleteMapping("/{id}")
    public String deleteCourseByID(@PathVariable Long id){
        Course selectedCourse = courseRepo.findCourseById(id);
        String courseName = selectedCourse.getCourseName();
        courseRepo.deleteById(id);
        return "Course " + courseName + " was deleted";
    }
}
