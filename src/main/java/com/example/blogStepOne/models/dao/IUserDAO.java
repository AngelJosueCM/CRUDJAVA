package com.example.blogStepOne.models.dao;
import com.example.blogStepOne.models.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IUserDAO {

    List<User> findAll();

    void save(User user);

    User findOne(User user);

    void delete(User user);
}
