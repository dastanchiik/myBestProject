package forAll.dao.repository;

import forAll.hibernate.Controller.models.Groups;
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
    public void save(Groups group){
        Session session = connection.getCurrentSession();
        session.save(group);
        System.out.println("saved ✅");
    }
    @Override
    public Groups getById(Long id){
        Session session = connection.getCurrentSession();
        return session.get(Groups.class,id);
    }

    @Override
    public List getALl() {
        Session session = connection.getCurrentSession();
        return session.createQuery("select p from Groups p", Groups.class).getResultList();
    }
    @Override
    public void deleteById(Long id){
        Session session = connection.getCurrentSession();
        session.delete(session.get(Groups.class,id));
    }

    @Override
    public void deleteAll() {
        Session session = connection.getCurrentSession();
        session.createQuery("delete from Groups ").executeUpdate();
    }

    @Override
    public void updateById(Long id, Groups group) {
        Session session = connection.getCurrentSession();
        Groups group1 = getById(id);
        group1.setGroupName(group.getGroupName());
        group1.setStudents(group.getStudents());
        group1.setCompany(group.getCompany());
        group1.setCourses(group.getCourses());
        group1.setDateOfStart(group.getDateOfStart());
        group1.setDateOfFinish(group.getDateOfFinish());
    }
}
