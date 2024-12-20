package com.example.controller;
import com.example.dto.UpdateCourseNameReq;
import com.example.model.Course;
import com.example.service.CourseService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/select/all")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }


    // 파라미터를 URI(주소)에 직접넣겠다.

    @GetMapping("/select")
    public Optional<Course> getCourse(@RequestParam Integer courseId) {
        return courseService.getCourse(courseId);
    }
    //optional = 값이 없을때 "null"을 반환하여 null point 에러 예방
    //delete = id를 기준으로 헤당 데이터를 삭제 = id라는 값이 필요함(@RequestBody 혹은 PathVariable 필요) = id가 null 뜨면 안됨

    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id) throws Exception {
        return courseService.deleteCourse(id);
    }

    @PutMapping("/put/{id}/{name}")
    public String updateCourse(@PathVariable Long id, @PathVariable String name) {
        return courseService.updateCourse(id, name);
    }

    @PutMapping("/putbody")
    public String updatebodyCoruse(@RequestBody @NotNull UpdateCourseNameReq req){//
        return courseService.updateCourse(req.getId(), req.getName());
    }




    @GetMapping("/selectuser")
    public String selectuser(@RequestParam Long id, @RequestParam String name){
            return courseService.getusercount(id, name);
    }
    /*
    *
    *
    *
    *
    *
    * */

/*delete API
@DeleteMapping("/delete")
public ResponseEntity<String> deleteCourse(@RequestBody Course course) {
    boolean isDeleted = courseService.deleteCourse(course); // 서비스에서 삭제 로직 수행
    if (isDeleted) {
        return ResponseEntity.ok("Course with ID " + course.getCourseId() + " has been deleted.");
* */

    // GET method
    // -> @RequestParam : QueryString, @PathVariable : URI

    // POST method
    // -> @RequestBody : JSON

    // 1. 기본적인 자바코드 구조
    // -> 접근제어자, static, 반환타입, 메소드명, 매개변수 등 작성법
    // 2. 상속(extends)의 개념

    @PostMapping("/insert")
    public Course createCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }



































    // courseId 를 파라미터로 강의명을 수정하는 api
    //강의명을                                                                              입력



}







