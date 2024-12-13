package com.example.controller;

import com.example.model.Course;
import com.example.service.CourseService;
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

    // 파라미터를 QueryStrg으로 넣겠다.
    @GetMapping("/select")
    public Optional<Course> getCourse(@RequestParam Integer courseId) {
        return courseService.getCourse(courseId);
    }



    /*update 필요한 쿼리스트링 : id,name(@requestBody 2개)*/
    /*
    1. 쿼리스트링으로 id와 이름을 호출
    2. 
*/
       @PutMapping("/putName")
    public Optional<Course> putname(@RequestBody Integer courseId,@RequestBody String courseName){
        return  courseService.putname(courseId & courseName);
    }
    /**/

/*update API
        @PutMapping("/update/{id}")
    public ResponseEntity<ItemDto> updateItem(@PathVariable Long id, @RequestBody ItemDto itemDto) {
    ItemDto updatedItem = itemService.updateItem(id, itemDto);
    return ResponseEntity.ok(updatedItem);
    }
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







