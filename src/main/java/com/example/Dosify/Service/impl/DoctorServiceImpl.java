package com.example.Dosify.Service.impl;

import com.example.Dosify.Controller.VaccinationCenterController;
import com.example.Dosify.Model.Doctor;
import com.example.Dosify.Model.VaccinationCenter;
import com.example.Dosify.Repository.CenterRepository;
import com.example.Dosify.Repository.DoctorRepository;
import com.example.Dosify.Service.DoctorService;
import com.example.Dosify.Transformer.DoctorTransformer;
import com.example.Dosify.Transformer.VaccinationCenterTransformer;
import com.example.Dosify.dto.requestDTO.DoctorRequestDTO;
import com.example.Dosify.dto.responseDTO.CenterResponseDTO;
import com.example.Dosify.dto.responseDTO.DoctorResponseDTO;
import com.example.Dosify.exception.CenterNotPresentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    CenterRepository centerRepository;
    @Autowired
    DoctorRepository doctorRepository;
    public DoctorResponseDTO addDoctor(DoctorRequestDTO doctorRequestDTO) throws CenterNotPresentException {

        Optional<VaccinationCenter> optionalCenter=centerRepository.findById(doctorRequestDTO.getCenterId());
        if(!optionalCenter.isPresent())
        {
            throw new CenterNotPresentException("Invalid center id!");
        }
        VaccinationCenter center = optionalCenter.get();


        Doctor doctor = DoctorTransformer.DoctorRequestDTOToDoctor(doctorRequestDTO);
        doctor.setVaccinationCenter(center);
        center.getDoctors().add(doctor);
        VaccinationCenter savedCenter = centerRepository.save(center);
//        CenterResponseDTO centerResponseDTO = VaccinationCenterTransformer.CenterToCenterResponseDTO(savedCenter);
        return DoctorTransformer.DoctorToDoctorResponseDTO(doctor);


    }
}
