package forAll.dao.repository;

import forAll.hibernate.Controller.models.Groups;

import java.util.List;

public interface GroupDao {
    void save(Groups group);
    void deleteAll();

    Groups getById(Long id);

    List<Groups> getALl();

    void deleteById(Long id);

    void updateById(Long id, Groups group);
}
