package by.DAO;

import by.model.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by УВД on 11.08.2017.
 */
@Repository
public class UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void saveUser(UserEntity userEntity){
        this.sessionFactory.getCurrentSession().persist(userEntity);
    }
    public UserEntity getUserByUsername(String username){
        UserEntity userEntity= (UserEntity) this.sessionFactory.getCurrentSession()
                .createQuery("from UserEntity where username=:username")
                .setString("username",username).uniqueResult();
        return userEntity;
    }
    public UserEntity getUserEntityById(int id){
        UserEntity userEntity= (UserEntity) this.sessionFactory.getCurrentSession().get(UserEntity.class,id);
        return userEntity;
    }
}
