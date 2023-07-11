package com.example.Dosify.Service.impl;

import com.example.Dosify.Model.VaccinationCenter;
import com.example.Dosify.Repository.CenterRepository;
import com.example.Dosify.Service.VaccinationCenterService;
import com.example.Dosify.Transformer.VaccinationCenterTransformer;
import com.example.Dosify.dto.requestDTO.CenterRequestDTO;
import com.example.Dosify.dto.responseDTO.CenterResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CenterServiceImpl implements VaccinationCenterService {
    @Autowired
    CenterRepository centerRepository;
    @Override
    public CenterResponseDTO addCenter(CenterRequestDTO centerRequestDTO) {

        VaccinationCenter vaccinationCenter = (VaccinationCenter) VaccinationCenterTransformer.CenterRequestDTOToCenter(centerRequestDTO);
        VaccinationCenter savedCenter = centerRepository.save(vaccinationCenter);
        return VaccinationCenterTransformer.CenterToCenterResponseDTO(savedCenter);
    }
}
