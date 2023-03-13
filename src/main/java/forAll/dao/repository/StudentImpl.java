package forAll.dao.repository;

import forAll.hibernate.Controller.models.Student;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public class StudentImpl implements StudentDao{
    @Autowired
    private SessionFactory connection;
    @Override
    public void save(Student student){
        Session session = connection.getCurrentSession();
        session.save(student);
        System.out.println("saved ✅");
    }
    @Override
    public Student getById(Long id){
        Session session = connection.getCurrentSession();
        return session.get(Student.class,id);
    }

    @Override
    public List getALl() {
        Session session = connection.getCurrentSession();
        return session.createQuery("select p from Student p", Student.class).getResultList();
    }
    @Override
    public void deleteById(Long id){
        try (Session session = connection.openSession()){
            session.beginTransaction();
            Student student = getById(id);
            session.delete(student);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteAll() {
        Session session = connection.getCurrentSession();
        session.createQuery("delete from Student");
    }

    @Override
    public void updateById(Long id, Student student) {
        Session session = connection.getCurrentSession();
        Student student1 = getById(id);
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setGroup(student.getGroup());
        student1.setEmail(student.getEmail());
        student1.setStudyFormat(student.getStudyFormat());
        session.merge(student1);
    }
}
