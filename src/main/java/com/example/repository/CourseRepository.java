package com.example.repository;
import com.example.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    // 추가 쿼리 메서드를 정의할 수 있습니다.
    //@Query("select m from Member m where m.lastName = :lastName and m.firstName = :firstName")
    @Modifying
    @Transactional
    //                    tb            class        tb
    @Query("DELETE FROM Course WHERE course_id = :courseId")
    void deleteByCourseId(@Param("courseId") Long courseId);

    @Modifying
    @Transactional
    @Query("update Course set course_name = :name where course_id = :id")
    void updateCourseId(@Param("id") Long id, @Param("name") String name);

    @Query("SELECT COUNT(*) from Course where course_id = :id and course_name = :name")
    Integer getusercount(@Param("id") Long id, @Param("name") String name);
}

