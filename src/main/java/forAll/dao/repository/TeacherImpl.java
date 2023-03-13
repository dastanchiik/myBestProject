package forAll.dao.repository;

import forAll.hibernate.Controller.models.Teacher;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public class TeacherImpl implements TeacherDao{
    @Autowired
    private SessionFactory connection;

    @Override
    public void save(Teacher teacher){
        Session session = connection.getCurrentSession();
        session.save(teacher);
        System.out.println("saved ✅");
    }
    @Override
    public Teacher getById(Long id){
        Session session = connection.getCurrentSession();
        return session.get(Teacher.class,id);
    }

    @Override
    public List getALl() {
        Session session = connection.getCurrentSession();
        return session.createQuery("select p from Teacher p", Teacher.class).getResultList();
    }
    @Override
    public void deleteById(Long id){
        try (Session session = connection.openSession()){
            session.beginTransaction();
            Teacher teacher = getById(id);
            session.delete(teacher);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteAll() {
        Session session = connection.getCurrentSession();
        session.createQuery("delete from Teacher ");
    }

    @Override
    public void updateById(Long id, Teacher teacher) {
        Session session = connection.getCurrentSession();
        Teacher teacher1 = getById(id);
        teacher1.setFirstName(teacher.getFirstName());
        teacher1.setLastName(teacher.getLastName());
        teacher1.setCourse(teacher.getCourse());
        teacher1.setEmail(teacher.getEmail());
        session.merge(teacher1);
    }
}
