package com.example.Dosify.Service;

import com.example.Dosify.Dto.RequestDTO.CenterRequestDTO;
import com.example.Dosify.Dto.ResponseDTO.CenterResponseDTO;
import org.springframework.stereotype.Service;


public interface VaccinationCenterService {
    public CenterResponseDTO addCenter(CenterRequestDTO centerRequestDTO);

}
