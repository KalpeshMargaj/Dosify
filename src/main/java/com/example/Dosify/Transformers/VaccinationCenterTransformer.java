package com.example.Dosify.Transformers;

import com.example.Dosify.Dto.RequestDTO.CenterRequestDTO;
import com.example.Dosify.Dto.ResponseDTO.CenterResponseDTO;
import com.example.Dosify.Model.VaccinationCenter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class VaccinationCenterTransformer {
    public static VaccinationCenter CenterRequestDtoToCenter(CenterRequestDTO centerRequestDTO)
    {
        return VaccinationCenter.builder()
                .name(centerRequestDTO.getName())
                .location(centerRequestDTO.getLocation())
                .centerType(centerRequestDTO.getCenterType())
                .build();
    }

    public static CenterResponseDTO CenterToCenterResponseDto(VaccinationCenter center)
    {
        return CenterResponseDTO.builder()
                .name(center.getName())
                .location(center.getLocation())
                .type(center.getCenterType())
                .build();
    }
}
