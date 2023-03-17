package forAll.dao.repository;

import forAll.hibernate.Controller.models.Company;

import java.util.List;

public interface CompanyDao {
    void save(Company company);

    Company getById(Long id);

    List getALl();

    void deleteById(Long id);

    void deleteAll();

    void updateById(Long id, Company company);
}
