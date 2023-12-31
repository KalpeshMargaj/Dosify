package com.example.Dosify.Controller;

import com.example.Dosify.Service.DoctorService;
import com.example.Dosify.dto.requestDTO.DoctorRequestDTO;
import com.example.Dosify.dto.responseDTO.DoctorResponseDTO;
import com.example.Dosify.exception.CenterNotPresentException;
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
    public ResponseEntity addDoctor(@RequestBody DoctorRequestDTO doctorRequestDTO)
    {
        try{
            DoctorResponseDTO doctorResponseDTO = doctorService.addDoctor(doctorRequestDTO);
            return new ResponseEntity(doctorResponseDTO,HttpStatus.CREATED);
        }
        catch (CenterNotPresentException e)
        {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
