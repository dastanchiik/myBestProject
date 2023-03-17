package forAll.dao.repository;

import forAll.hibernate.Controller.models.Student;

import java.util.List;

public interface StudentDao {
    void save(Student student);

    Student getById(Long id);

    List<Student> getALl();

    void deleteById(Long id);

    void deleteAll();

    void updateById(Long id, Student student);

    List<Student> findAllStudent(Long id);
}
