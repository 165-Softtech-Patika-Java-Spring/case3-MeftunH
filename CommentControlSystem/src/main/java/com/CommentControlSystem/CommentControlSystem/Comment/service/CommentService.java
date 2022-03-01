package com.CommentControlSystem.CommentControlSystem.Comment.service;


import com.CommentControlSystem.CommentControlSystem.Comment.converter.CommentMapper;
import com.CommentControlSystem.CommentControlSystem.Comment.dto.CommentDto;
import com.CommentControlSystem.CommentControlSystem.Comment.dto.CommentSaveRequestDto;
import com.CommentControlSystem.CommentControlSystem.Comment.entity.Comment;
import com.CommentControlSystem.CommentControlSystem.Comment.exception.ProductHasNotComment;
import com.CommentControlSystem.CommentControlSystem.Comment.exception.UserHasNotCommentException;
import com.CommentControlSystem.CommentControlSystem.Comment.service.entity.CommentEntityService;
import com.CommentControlSystem.CommentControlSystem.Product.entity.Product;
import com.CommentControlSystem.CommentControlSystem.Product.service.ProductService;
import com.CommentControlSystem.CommentControlSystem.Product.service.entityService.ProductEntityService;
import com.CommentControlSystem.CommentControlSystem.User.entity.User;
import com.CommentControlSystem.CommentControlSystem.User.service.entity.UserEntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {
    private final CommentEntityService commentEntityService;
    private final UserEntityService userEntityService;
    private final ProductEntityService productEntityService;

    public CommentDto save(CommentSaveRequestDto requestDto) {
        Comment comment = CommentMapper.INSTANCE.convertToComment(requestDto);

        comment = commentEntityService.save(comment);

        CommentDto commentDto = CommentMapper.INSTANCE.convertToCommentDto(comment);

        return commentDto;
    }


    public void delete(Long id) {
        Comment comment = commentEntityService.getByIdWithControl(id);

        commentEntityService.delete(comment);
    }

    public List<CommentDto> findByUserId(Long id) throws UserHasNotCommentException {
        List<Comment> comments = commentEntityService.findByUserId(id);
        List<CommentDto> commentDto = CommentMapper.INSTANCE.convertToCommentDtoList(comments);
        if (commentDto.isEmpty()) {
            User user = userEntityService.getByIdWithControl(id);
            throw new UserHasNotCommentException(user.getNickname()+" User Has Not Comment");
        }
        return commentDto;
    }


    public List<CommentDto> findByProductId(Long id) throws ProductHasNotComment {
        Product product = productEntityService.getByIdWithControl(id);
        List<Comment> comments = commentEntityService.findByProductId(id);
        List<CommentDto> commentDto = CommentMapper.INSTANCE.convertToCommentDtoList(comments);
        if (commentDto.isEmpty()) {

            throw new ProductHasNotComment(product.getName()+" Product Has Not Comment");
        }
        return commentDto;
    }

}
