package forAll.dao.repository;

import forAll.hibernate.Controller.models.Group;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public class GroupImpl implements GroupDao{
    @Autowired
    private SessionFactory connection;
    @Override
    public void save(Group group){
        Session session = connection.getCurrentSession();
        session.save(group);
        System.out.println("saved ✅");
    }
    @Override
    public Group getById(Long id){
        Session session = connection.getCurrentSession();
        return session.get(Group.class,id);
    }

    @Override
    public List getALl() {
        Session session = connection.getCurrentSession();
        return session.createQuery("select p from Group p", Group.class).getResultList();
    }
    @Override
    public void deleteById(Long id){
        try (Session session = connection.openSession()){
            session.beginTransaction();
            Group group = getById(id);
            session.delete(group);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteAll() {
        Session session = connection.getCurrentSession();
        session.createQuery("delete from Group ");
    }

    @Override
    public void updateById(Long id, Group group) {
        Session session = connection.getCurrentSession();
        Group group1 = getById(id);
        group1.setGroupName(group.getGroupName());
        group1.setStudents(group.getStudents());
        group1.setCompany(group.getCompany());
        group1.setCourses(group.getCourses());
        group1.setDateOfStart(group.getDateOfStart());
        group1.setDateOfFinish(group.getDateOfFinish());
    }
}
