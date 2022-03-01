package com.CommentControlSystem.CommentControlSystem.User.dao;

import com.CommentControlSystem.CommentControlSystem.User.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByNickname(String nickname);
    User findByPhoneNumber(String phonebumber);
    User findByNicknameAndPhoneNumber(String nickname, String phoneNumber);
}
