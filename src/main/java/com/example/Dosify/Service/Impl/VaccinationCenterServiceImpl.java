package com.example.Dosify.Service.Impl;

import com.example.Dosify.Dto.RequestDTO.CenterRequestDTO;
import com.example.Dosify.Dto.ResponseDTO.CenterResponseDTO;
import com.example.Dosify.Model.VaccinationCenter;
import com.example.Dosify.Repository.CenterRepository;
import com.example.Dosify.Service.VaccinationCenterService;
import com.example.Dosify.Transformers.VaccinationCenterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationCenterServiceImpl implements VaccinationCenterService {
    @Autowired
    CenterRepository centerRepository;
    @Override
    public CenterResponseDTO addCenter(CenterRequestDTO centerRequestDTO) {
        VaccinationCenter vaccinationCenter = VaccinationCenterTransformer.CenterRequestDtoToCenter(centerRequestDTO);
        VaccinationCenter savedCenter = centerRepository.save(vaccinationCenter);

        return VaccinationCenterTransformer.CenterToCenterResponseDto(savedCenter);
    }
}
