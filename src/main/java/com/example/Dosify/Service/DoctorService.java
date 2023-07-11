package com.example.Dosify.Service;

import com.example.Dosify.dto.requestDTO.DoctorRequestDTO;
import com.example.Dosify.dto.responseDTO.DoctorResponseDTO;
import com.example.Dosify.exception.CenterNotPresentException;
public interface DoctorService {
    public DoctorResponseDTO addDoctor(DoctorRequestDTO doctorRequestDTO) throws CenterNotPresentException;
}
