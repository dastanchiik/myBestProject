package forAll.dao.repository;

import forAll.hibernate.Controller.models.Teacher;

import java.util.List;

public interface TeacherDao {
    void save(Teacher teacher);

    Teacher getById(Long id);

    List<Teacher> getALl();

    void deleteById(Long id);

    void deleteAll();

    void updateById(Long id, Teacher teacher);

    List<Teacher> findAllTeacher(Long id);
}
