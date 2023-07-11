package com.example.Dosify.Service;

import com.example.Dosify.Model.User;
import com.example.Dosify.dto.requestDTO.UserRequestDTO;
import com.example.Dosify.dto.responseDTO.UserResponseDTO;

public interface UserService {
    public UserResponseDTO addUser(UserRequestDTO userRequestDTO);
 }
