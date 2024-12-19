package com.example.service;

import com.example.model.Course;
import com.example.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService<Coruse> {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public Optional<Course> getCourse(Integer courseId) {
        return courseRepository.findById(courseId);
    }

    public String deleteCourse(Long Courses) throws Exception {

        courseRepository.deleteByCourseId(Courses);

        return "ok";
    }


    public String updateCourse(Long id, String name){
        courseRepository.updateCourseId(id, name);
        return "ok";
    }

    public String getusercount(Long id, String name) {
        Integer count = courseRepository.getusercount(id, name);
        try {
            if(count == 1) {
                return "유저정보가 존재합니다";
            }else if (count==0){
                return "유저정보가 존재하지 않습니다.";
            }else {
                return"예상치 못한 오류가 발생하였습니다.";
            }
        } catch (RuntimeException e) {

            throw new RuntimeException(e);
        }

    }

}
