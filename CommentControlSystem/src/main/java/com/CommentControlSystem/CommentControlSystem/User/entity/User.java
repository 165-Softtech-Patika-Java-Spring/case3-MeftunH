package com.CommentControlSystem.CommentControlSystem.User.entity;

import com.CommentControlSystem.CommentControlSystem.General.entity.BaseEntity;
import com.CommentControlSystem.CommentControlSystem.User.annotations.UniqueEmail;
import com.CommentControlSystem.CommentControlSystem.User.enums.UserType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "USERS")
@Getter
@Setter
public class User extends BaseEntity {
    @Id
    @SequenceGenerator(name = "Users", sequenceName = "USERS_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Users")
    private Long id;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @Column(name = "SURNAME", nullable = false, length = 50)
    private String surname;

    @Column(name="NICKNAME", nullable = false, length = 50)
    private String nickname;

    @Email(message = "Email not valid")
    @Column(name = "EMAIL", nullable = false, length = 50, unique = true)
    private String email;

    @Pattern(regexp="^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$", message = "Phone number not valid")
    @Column(name = "PHONENUMBER", nullable = false, length = 50, unique = true)
    private String phoneNumber;

    @Column(name = "PASSWORD", nullable = false, length = 50)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_TYPE", length = 30)
    private UserType userType;

}

