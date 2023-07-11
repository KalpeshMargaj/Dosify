package com.example.Dosify.Transformer;

import com.example.Dosify.Model.User;
import com.example.Dosify.dto.requestDTO.UserRequestDTO;
import com.example.Dosify.dto.responseDTO.UserResponseDTO;
import lombok.experimental.UtilityClass;

@UtilityClass

public class UserTransformer {
    public static User UserRequestDTOTOUser(UserRequestDTO userRequestDTO)
    {
        return  User.builder()
                .name(userRequestDTO.getName())
                .age(userRequestDTO.getAge())
                .emailId(userRequestDTO.getEmailId())
                .gender(userRequestDTO.getGender())
                .mobNo(userRequestDTO.getMobNo())
                .build();
    }

    public static UserResponseDTO UserToUserResponseDTO(User user)
    {
        return UserResponseDTO.builder()
                .name(user.getName())
                .message("Congrats! Registration successful.")
                .build();
    }
}
