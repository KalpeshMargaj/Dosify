package com.example.Dosify.Service.impl;

import com.example.Dosify.Model.User;
import com.example.Dosify.Repository.UserRepository;
import com.example.Dosify.Service.UserService;
import com.example.Dosify.Transformer.UserTransformer;
import com.example.Dosify.dto.requestDTO.UserRequestDTO;
import com.example.Dosify.dto.responseDTO.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    public UserResponseDTO addUser(UserRequestDTO userRequestDTO)
    {
//        User user = new User();
//        user.setName(userRequestDTO.getName());
//        user.setAge(userRequestDTO.getAge());
//        user.setEmailId(userRequestDTO.getEmailId());
//        user.setGender(userRequestDTO.getGender());
//        user.setMobNo(userRequestDTO.getMobNo());

        User user = UserTransformer.UserRequestDTOTOUser(userRequestDTO);

        User savedUser=userRepository.save(user);

//        UserResponseDTO userResponseDTO = new UserResponseDTO();
//        userResponseDTO.setName(savedUser.getName());
//        userResponseDTO.setMessage("Congrats! Registration successful.");
        UserResponseDTO userResponseDTO =UserTransformer.UserToUserResponseDTO(savedUser);
        return userResponseDTO;
    }
}
