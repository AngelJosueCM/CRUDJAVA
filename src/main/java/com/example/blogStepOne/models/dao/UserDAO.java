package com.example.blogStepOne.models.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.blogStepOne.models.entity.User;

import java.util.List;

@Repository("UserDAOJPA")
public class UserDAO implements IUserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll(){return entityManager.createQuery("from User").getResultList();}

    @Override
    @Transactional

    public void save(User user) {
        if (user.getId() != null && user.getId() > 0){
            entityManager.merge(user);
        }else {
            entityManager.persist(user);
        }
    }
    @Override
    public User findOne(User user){
        if (user.getId() == null && user.getId() > 0){
            entityManager.persist(user);
        }else {
            return null;
        }
        return user;
    }

    @Override
    public void delete(User user) {
        if (user.getId() != null && user.getId() > 0){
            delete(user);
        }
    }

    }

