package com.CommentControlSystem.CommentControlSystem.Comment.service.entity;

import com.CommentControlSystem.CommentControlSystem.Comment.dao.CommentDao;
import com.CommentControlSystem.CommentControlSystem.Comment.dto.CommentDto;
import com.CommentControlSystem.CommentControlSystem.Comment.entity.Comment;
import com.CommentControlSystem.CommentControlSystem.General.service.BaseEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentEntityService extends BaseEntityService<Comment, CommentDao> {
    public CommentEntityService(CommentDao dao) {
        super(dao);
    }
    public List<Comment> findByUserId(Long idUser){
        return getDao().findByUserId(idUser);
    }
    public List<Comment> findByProductId(Long idProduct){
        return getDao().findByProductId(idProduct);
    }

}
