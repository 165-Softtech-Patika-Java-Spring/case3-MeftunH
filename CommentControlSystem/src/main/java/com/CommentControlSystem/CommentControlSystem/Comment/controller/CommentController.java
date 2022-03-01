package com.CommentControlSystem.CommentControlSystem.Comment.controller;

import com.CommentControlSystem.CommentControlSystem.Comment.dto.CommentDto;
import com.CommentControlSystem.CommentControlSystem.Comment.dto.CommentSaveRequestDto;
import com.CommentControlSystem.CommentControlSystem.Comment.exception.ProductHasNotComment;
import com.CommentControlSystem.CommentControlSystem.Comment.exception.UserHasNotCommentException;
import com.CommentControlSystem.CommentControlSystem.Comment.service.CommentService;
import com.CommentControlSystem.CommentControlSystem.General.dto.RestResponse;
import com.CommentControlSystem.CommentControlSystem.Product.dto.ProductDto;
import com.CommentControlSystem.CommentControlSystem.Product.dto.ProductSaveRequestDto;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity createComment(@RequestBody CommentSaveRequestDto commentSaveRequestDto) {
        CommentDto commentDto = commentService.save(commentSaveRequestDto);
        return ResponseEntity
                .ok(RestResponse.of(commentDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteComment(@PathVariable Long id) {
        commentService.delete(id);
        return ResponseEntity.
                ok(RestResponse.empty());
    }

    @GetMapping("/user/{user_id}")
    public ResponseEntity getUserComments(@PathVariable("user_id") @ApiParam(name = "user_id", value = "User id", example = "1") Long user_id)  throws UserHasNotCommentException {
        List<CommentDto> commentDto = commentService.findByUserId(user_id);
        return ResponseEntity
                .ok(RestResponse.of(commentDto));
    }
    @GetMapping("/product/{product_id}")
    public ResponseEntity getProductComments(@PathVariable("product_id") @ApiParam(name = "product_id", value = "Product id", example = "1") Long product_id) throws ProductHasNotComment {
        List<CommentDto> commentDto = commentService.findByProductId(product_id);
        return ResponseEntity
                .ok(RestResponse.of(commentDto));
    }
}
