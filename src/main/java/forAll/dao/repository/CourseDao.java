package forAll.dao.repository;

import forAll.hibernate.Controller.models.Course;
import forAll.hibernate.Controller.models.Groups;

import java.util.List;

public interface CourseDao {
    void save(Course course);

    Course getById(Long id);

    List<Course> getALl();

    void deleteById(Long id);

    void deleteAll();

    void updateById(Long id, Course course);

    List<Course> connectionFindAll(Long id);
}
