package com.example.Dosify.Transformer;

import com.example.Dosify.Model.VaccinationCenter;
import com.example.Dosify.Service.VaccinationCenterService;
import com.example.Dosify.dto.requestDTO.CenterRequestDTO;
import com.example.Dosify.dto.responseDTO.CenterResponseDTO;
public class VaccinationCenterTransformer {
    public static VaccinationCenter CenterRequestDTOToCenter(CenterRequestDTO centerRequestDTO)
    {
        return VaccinationCenter.builder()
                .name(centerRequestDTO.getName())
                .location(centerRequestDTO.getLocation())
                .centerType(centerRequestDTO.getCenterType())
                .build();
    }
    public static CenterResponseDTO CenterToCenterResponseDTO(VaccinationCenter center)
    {
        return CenterResponseDTO.builder()
                .name(center.getName())
                .location(center.getLocation())
                .centerType(center.getCenterType())
                .build();
    }
}
