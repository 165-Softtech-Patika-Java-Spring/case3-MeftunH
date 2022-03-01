package com.CommentControlSystem.CommentControlSystem.Comment.converter;

import com.CommentControlSystem.CommentControlSystem.Comment.dto.CommentDto;
import com.CommentControlSystem.CommentControlSystem.Comment.dto.CommentSaveRequestDto;
import com.CommentControlSystem.CommentControlSystem.Comment.entity.Comment;
import com.CommentControlSystem.CommentControlSystem.Product.converter.ProductMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);
    CommentDto convertToCommentDto(Comment comment);
    Comment convertToComment(CommentSaveRequestDto commentSaveRequestDto);
    List<CommentDto> convertToCommentDtoList(List<Comment> commentList);
}
