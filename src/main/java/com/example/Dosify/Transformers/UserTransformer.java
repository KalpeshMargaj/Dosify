package com.example.Dosify.Transformers;

import com.example.Dosify.Dto.RequestDTO.UserRequestDTO;
import com.example.Dosify.Dto.ResponseDTO.UserResponseDTO;
import com.example.Dosify.Model.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserTransformer {
    public static User UserRequestDtoToUser(UserRequestDTO userRequestDTO){
        return User.builder()
                .name(userRequestDTO.getName())
                .emailId(userRequestDTO.getEmailId())
                .age(userRequestDTO.getAge())
                .mobNo(userRequestDTO.getMobNo())
                .gender(userRequestDTO.getGender())
                .build();
    }

    public static UserResponseDTO UserToUserResponseDto(User user,String message){
        return UserResponseDTO.builder()
                .name(user.getName())
                .message(message)
                .build();
    }
}
