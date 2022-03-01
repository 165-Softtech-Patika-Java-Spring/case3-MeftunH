package com.CommentControlSystem.CommentControlSystem.Comment.entity;

import com.CommentControlSystem.CommentControlSystem.General.entity.BaseEntity;
import com.CommentControlSystem.CommentControlSystem.Product.entity.Product;
import com.CommentControlSystem.CommentControlSystem.User.entity.User;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "COMMENT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends BaseEntity {
    @Id
    @SequenceGenerator(name = "Comment", sequenceName = "COMMENT_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "Comment")
    private Long id;
    @Column(name = "ID_PRODUCT")
    private Long productId;

    @Column(name = "ID_USER")
    private Long userId;
    @Column(name = "TITLE", nullable = false,length = 255)
    private String title;

    @Column(name = "CONTENT", nullable = false,length = 255)
    private String content;


}
