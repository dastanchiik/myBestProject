package forAll.dao.repository;

import forAll.hibernate.Controller.models.Group;

import java.util.List;

public interface GroupDao {
    void save(Group group);
    void deleteAll();

    Group getById(Long id);

    List getALl();

    void deleteById(Long id);

    void updateById(Long id, Group group);
}
