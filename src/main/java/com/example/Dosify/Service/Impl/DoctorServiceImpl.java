package com.example.Dosify.Service.Impl;

import com.example.Dosify.Dto.RequestDTO.DoctorRequestDTO;
import com.example.Dosify.Dto.ResponseDTO.CenterResponseDTO;
import com.example.Dosify.Dto.ResponseDTO.DoctorResponseDTO;
import com.example.Dosify.Exception.CenterNotPresentException;
import com.example.Dosify.Model.Doctor;
import com.example.Dosify.Model.VaccinationCenter;
import com.example.Dosify.Repository.CenterRepository;
import com.example.Dosify.Repository.DoctorRepository;
import com.example.Dosify.Service.DoctorService;
import com.example.Dosify.Service.VaccinationCenterService;
import com.example.Dosify.Transformers.DoctorTransformer;
import com.example.Dosify.Transformers.VaccinationCenterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    CenterRepository centerRepository;
    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public DoctorResponseDTO addDoctor(DoctorRequestDTO doctorRequestDTO) throws CenterNotPresentException {
        Optional<VaccinationCenter> optionalCenter = centerRepository.findById(doctorRequestDTO.getCenterId());
        if(!optionalCenter.isPresent())
        {
            throw new CenterNotPresentException("Invalid center id.");
        }

        VaccinationCenter center = optionalCenter.get();
        Doctor doctor = DoctorTransformer.DoctorRequestDtoToDoctor(doctorRequestDTO);
        doctor.setVaccinationCenter(center);
        center.getDoctorList().add(doctor);
        VaccinationCenter savedCenter = centerRepository.save(center); //saves both doctor and center as center is parent.
        CenterResponseDTO centerResponseDTO = VaccinationCenterTransformer.CenterToCenterResponseDto(savedCenter);
        DoctorResponseDTO doctorResponseDTO = DoctorTransformer.DoctorToDoctorResponseDto(doctor);
        return doctorResponseDTO;
    }
}
