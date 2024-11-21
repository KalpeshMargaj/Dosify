package com.example.Dosify.Service;

import com.example.Dosify.Dto.RequestDTO.UserRequestDTO;
import com.example.Dosify.Dto.ResponseDTO.UserResponseDTO;

import java.util.List;


public interface UserService {
    public UserResponseDTO addUser(UserRequestDTO userRequestDTO);

    public UserResponseDTO findUserByEmailId(String emailId);

    List<UserResponseDTO> findPeopleReadyForDose2();
}
