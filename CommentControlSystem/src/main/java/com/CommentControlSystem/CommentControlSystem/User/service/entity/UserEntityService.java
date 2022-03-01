package com.CommentControlSystem.CommentControlSystem.User.service.entity;

import com.CommentControlSystem.CommentControlSystem.General.service.BaseEntityService;
import com.CommentControlSystem.CommentControlSystem.Product.entity.Product;
import com.CommentControlSystem.CommentControlSystem.User.dao.UserDao;
import com.CommentControlSystem.CommentControlSystem.User.entity.User;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;

@Service
public class UserEntityService extends BaseEntityService<User, UserDao> {
    public UserEntityService(UserDao dao) {
        super(dao);
    }
    public List<User> findAll() {
        return getDao().findAll();
    }
    public User findByNickname(String username) {
        return getDao().findByNickname(username);
    }
    public User findByNicknameAndPhoneNumber(String username, String phoneNumber) {
        return getDao().findByNicknameAndPhoneNumber(username, phoneNumber);
    }

}
