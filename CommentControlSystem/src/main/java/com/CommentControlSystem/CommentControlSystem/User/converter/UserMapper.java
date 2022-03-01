package com.CommentControlSystem.CommentControlSystem.User.converter;

import com.CommentControlSystem.CommentControlSystem.Product.dto.ProductDto;
import com.CommentControlSystem.CommentControlSystem.Product.entity.Product;
import com.CommentControlSystem.CommentControlSystem.User.dto.UserDto;
import com.CommentControlSystem.CommentControlSystem.User.dto.UserSaveRequestDto;
import com.CommentControlSystem.CommentControlSystem.User.dto.UserUpdateRequestDto;
import com.CommentControlSystem.CommentControlSystem.User.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto convertToUserDto(User user);
    User convertToUser(UserSaveRequestDto userSaveRequestDto);
    User convertToUser(UserUpdateRequestDto userUpdateRequestDto);
    List<UserDto> convertToUserDtoList(List<User> userDto);

}
