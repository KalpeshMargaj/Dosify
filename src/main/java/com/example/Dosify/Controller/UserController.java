package com.example.Dosify.Controller;

import com.example.Dosify.Dto.RequestDTO.UserRequestDTO;
import com.example.Dosify.Dto.ResponseDTO.UserResponseDTO;
import com.example.Dosify.Model.User;
import com.example.Dosify.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserResponseDTO> addUser(@RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO savedUser = userService.addUser(userRequestDTO);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/byEmail")
    public ResponseEntity<UserResponseDTO> findByEmailId(@RequestParam String emailId){
        UserResponseDTO userResponseDTO = userService.findUserByEmailId(emailId);
        return new ResponseEntity<>(userResponseDTO,HttpStatus.OK);
    }

    @GetMapping("/peopleReadyForDose2")
    public ResponseEntity<List<UserResponseDTO>> findPeopleReadyForDose2(){
        List<UserResponseDTO> userNameList = userService.findPeopleReadyForDose2();
        return new ResponseEntity<>(userNameList,HttpStatus.FOUND);
    }

}
