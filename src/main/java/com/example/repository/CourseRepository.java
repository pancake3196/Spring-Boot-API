package com.example.repository;

import com.example.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    // 추가 쿼리 메서드를 정의할 수 있습니다.
}
