package com.example.Dosify.Service;

import com.example.Dosify.dto.requestDTO.CenterRequestDTO;
import com.example.Dosify.dto.responseDTO.CenterResponseDTO;
public interface VaccinationCenterService {
    public CenterResponseDTO addCenter(CenterRequestDTO centerRequestDTO);
}
