package com.example.Dosify.Controller;

import com.example.Dosify.Dto.RequestDTO.DoctorRequestDTO;
import com.example.Dosify.Dto.ResponseDTO.DoctorResponseDTO;
import com.example.Dosify.Exception.CenterNotPresentException;
import com.example.Dosify.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/add")
    public ResponseEntity<?> addDoctor(@RequestBody DoctorRequestDTO doctorRequestDTO){
        try{
            DoctorResponseDTO doctorResponseDTO = doctorService.addDoctor(doctorRequestDTO);
            return new ResponseEntity<>(doctorResponseDTO,HttpStatus.CREATED);
        }catch (CenterNotPresentException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
