package com.example.Dosify.Service.Impl;

import com.example.Dosify.Dto.RequestDTO.UserRequestDTO;
import com.example.Dosify.Dto.ResponseDTO.UserResponseDTO;
import com.example.Dosify.Model.User;
import com.example.Dosify.Repository.UserRepository;
import com.example.Dosify.Service.UserService;
import com.example.Dosify.Transformers.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserResponseDTO addUser(UserRequestDTO userRequestDTO) {
        User user = UserTransformer.UserRequestDtoToUser(userRequestDTO);
        user.setDose1Taken(false);
        user.setDose2Taken(false);
        User savedUser = userRepository.save(user);
        UserResponseDTO userResponseDTO = UserTransformer.UserToUserResponseDto(savedUser,"Congrats !! You have registered successfully.");

        return userResponseDTO;
    }

    @Override
    public UserResponseDTO findUserByEmailId(String emailId) {
        User user = userRepository.findByEmailId(emailId);
        UserResponseDTO userResponseDTO = UserTransformer.UserToUserResponseDto(user,"User Found!");
        return userResponseDTO;
    }

    @Override
    public List<UserResponseDTO> findPeopleReadyForDose2() {
        List<UserResponseDTO> userNameList = new ArrayList<>();
        List<User> userList = userRepository.findUserReadyForDose2();
        for(User user:userList)
        {
            UserResponseDTO userResponseDTO = UserTransformer.UserToUserResponseDto(user,"Ready for dose2.");
            userNameList.add(userResponseDTO);
        }

        return userNameList;
    }

}
