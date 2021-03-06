package ir.maktab.model.repository;

import ir.maktab.model.entity.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@org.springframework.stereotype.Repository
public interface CourseRepository extends Repository<Course, Long> {

    Course save(Course course);

    List<Course> findAll();

    Course findByCourseTitle(String title);

    @Query("select userList from Course where courseTitle=:title")
    List<User> findUsersByCourseTitle(@Param("title") String title);

    @Query("select examList from Course where courseTitle=:courseTitle")
    List<Exam> findExamOfCourse(@Param("courseTitle") String courseTitle);


}
