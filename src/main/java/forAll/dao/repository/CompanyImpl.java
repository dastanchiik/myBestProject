package forAll.dao.repository;

import forAll.hibernate.Controller.models.Company;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CompanyImpl implements CompanyDao {
    @Autowired
    private SessionFactory connection;

    @Override
    public void save(Company company) {
        Session session = connection.getCurrentSession();
        session.save(company);
        System.out.println("saved ✅");
    }

    @Override
    public Company getById(Long id) {
        Session session = connection.getCurrentSession();
        return session.get(Company.class, id);
    }

    @Override
    public List getALl() {
        Session session = connection.getCurrentSession();
        return session.createQuery("select company from Company company").getResultList();
    }

    @Override
    public void deleteById(Long id) {
        Session session = connection.getCurrentSession();
        session.delete(session.get(Company.class, id));
    }

    @Override
    public void deleteAll() {
        Session session = connection.getCurrentSession();
        session.createQuery("delete from Company").executeUpdate();
    }

    @Override
    public void updateById(Long id, Company company) {
        Session session = connection.getCurrentSession();
        Company company1 = getById(id);
        company1.setCompanyName(company.getCompanyName());
        company1.setLocatedCountry(company.getLocatedCountry());
        session.merge(company1);
    }
}
