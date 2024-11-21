package com.example.Dosify.Controller;

import com.example.Dosify.Dto.RequestDTO.CenterRequestDTO;
import com.example.Dosify.Dto.ResponseDTO.CenterResponseDTO;
import com.example.Dosify.Service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/center")
public class vaccinationCenterController {

    @Autowired
    VaccinationCenterService vaccinationCenterService;

    @PostMapping("/add")
    public ResponseEntity<CenterResponseDTO> addCenter(@RequestBody CenterRequestDTO centerRequestDTO){
        CenterResponseDTO centerResponseDTO = vaccinationCenterService.addCenter(centerRequestDTO);
        return new ResponseEntity<>(centerResponseDTO, HttpStatus.CREATED);
    }

}
