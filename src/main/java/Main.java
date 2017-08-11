import by.model.RoleEntity;
import by.model.UserEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by УВД on 11.08.2017.
 */
public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {
            session.beginTransaction();
//            UserEntity userEntity= (UserEntity) session.get(UserEntity.class,1);
//            RoleEntity roleEntity=new RoleEntity();
//            Set<UserEntity> userEntitySet=new HashSet<UserEntity>();
//            Set<RoleEntity> roleEntitySet=new HashSet<RoleEntity>();
//            roleEntity.setName("ROLE_USER");
//            userEntitySet.add(userEntity);
//            roleEntitySet.add(roleEntity);
//            userEntity.setRoleEntitySet(roleEntitySet);
//            roleEntity.setUserEntities(userEntitySet);
//            session.saveOrUpdate(userEntity);
//            session.save(roleEntity);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}