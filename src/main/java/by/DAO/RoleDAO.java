package by.DAO;

import by.model.RoleEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by УВД on 11.08.2017.
 */
@Repository
public class RoleDAO {
    @Autowired
    private SessionFactory sessionFactory;
    public RoleEntity getRoleById(int id){
        RoleEntity roleEntity= (RoleEntity) this.sessionFactory.getCurrentSession().get(RoleEntity.class,id);
        return roleEntity;
    }
}
