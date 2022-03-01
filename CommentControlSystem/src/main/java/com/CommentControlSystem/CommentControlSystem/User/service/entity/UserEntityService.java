package com.CommentControlSystem.CommentControlSystem.User.service.entity;

import com.CommentControlSystem.CommentControlSystem.General.service.BaseEntityService;
import com.CommentControlSystem.CommentControlSystem.User.dao.UserDao;
import com.CommentControlSystem.CommentControlSystem.User.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserEntityService extends BaseEntityService<User, UserDao> {
    public UserEntityService(UserDao dao) {
        super(dao);
    }
}
