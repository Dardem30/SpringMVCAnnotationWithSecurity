package by.service;

import by.DAO.RoleDAO;
import by.DAO.UserDAO;
import by.model.RoleEntity;
import by.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by УВД on 11.08.2017.
 */
@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private RoleDAO roleDAO;
    @Transactional
    public void saveUser(UserEntity userEntity){
        Set<RoleEntity> roleEntitySet=new HashSet<RoleEntity>();
        roleEntitySet.add(roleDAO.getRoleById(1));
        userEntity.setRoleEntitySet(roleEntitySet);
        userDAO.saveUser(userEntity);
    }
    @Transactional
    public UserEntity getUserByUsername(String username){
        return userDAO.getUserByUsername(username);
    }
    @Transactional
    public UserEntity getUserEntityById(int id){
        return this.userDAO.getUserEntityById(id);
    }

    }
