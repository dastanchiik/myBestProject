package forAll.dao.repository;

import forAll.hibernate.Controller.models.Course;
import forAll.hibernate.Controller.models.Groups;

import java.util.List;

public interface CourseDao {
    void save(Course course);

    Course getById(Long id);

    List getALl();

    void deleteById(Long id);

    void deleteAll();

    void updateById(Long id, Course course);
    List<Groups> connectionFindAll(Long id,Course course);
}
