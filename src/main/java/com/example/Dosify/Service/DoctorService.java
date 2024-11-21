package com.example.Dosify.Service;

import com.example.Dosify.Dto.RequestDTO.DoctorRequestDTO;
import com.example.Dosify.Dto.ResponseDTO.DoctorResponseDTO;
import com.example.Dosify.Exception.CenterNotPresentException;

public interface DoctorService {
    DoctorResponseDTO addDoctor(DoctorRequestDTO doctorRequestDTO) throws CenterNotPresentException;
}
