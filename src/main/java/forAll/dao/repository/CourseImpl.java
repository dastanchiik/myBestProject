package forAll.dao.repository;

import forAll.hibernate.Controller.models.Company;
import forAll.hibernate.Controller.models.Course;
import forAll.hibernate.Controller.models.Groups;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
@Transactional

public class CourseImpl implements CourseDao {
    @Autowired
    private SessionFactory connection;
    @Autowired
    private CompanyDao companyDao;

    @Override
    public void save(Course course) {
        Session session = connection.getCurrentSession();
        session.save(course);
        System.out.println("saved ✅");
    }

    @Override
    public Course getById(Long id) {
        Session session = connection.getCurrentSession();
        return session.get(Course.class, id);
    }

    @Override
    public List<Course> getALl() {
        Session session = connection.getCurrentSession();
        return session.createQuery("select p from Course p").getResultList();
    }

    @Override
    public void deleteById(Long id) {
        Session session = connection.getCurrentSession();
        session.delete(session.get(Course.class, id));
    }

    @Override
    public void deleteAll() {
        Session session = connection.getCurrentSession();
        session.createQuery("delete from Course").executeUpdate();
    }

    @Override
    public void updateById(Long id, Course course) {
        Session session = connection.getCurrentSession();
        Course course1 = getById(id);
        course1.setCourseName(course.getCourseName());
        course1.setCompany(course.getCompany());
        course1.setTeacher(course.getTeacher());
        course1.setGroups(course.getGroups());
        course1.setDuration(course.getDuration());
        session.merge(course1);
    }

    @Override
    public List<Course> connectionFindAll(Long id) {
        List<Course> courses = new ArrayList<>();
        Company company = companyDao.getById(id);
        for (Course course2 : getALl()) {
            Course course1 = getById(course2.getId());
            if (course1.getCompany().getId() == company.getId()) {
                courses.add(course1);
            }
        }
        return courses;
    }

}
