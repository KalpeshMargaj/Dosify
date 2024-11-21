package com.example.Dosify.Transformers;

import com.example.Dosify.Dto.RequestDTO.DoctorRequestDTO;
import com.example.Dosify.Dto.ResponseDTO.CenterResponseDTO;
import com.example.Dosify.Dto.ResponseDTO.DoctorResponseDTO;
import com.example.Dosify.Model.Doctor;
import lombok.experimental.UtilityClass;

import javax.print.Doc;
@UtilityClass
public class DoctorTransformer {
    public static Doctor DoctorRequestDtoToDoctor(DoctorRequestDTO doctorRequestDTO)
    {
        return Doctor.builder()
                .name(doctorRequestDTO.getName())
                .age(doctorRequestDTO.getAge())
                .mobNo(doctorRequestDTO.getMobNo())
                .gender(doctorRequestDTO.getGender())
                .emailId(doctorRequestDTO.getEmailId())
                .build();
    }

    public static DoctorResponseDTO DoctorToDoctorResponseDto(Doctor doctor)
    {
        CenterResponseDTO centerResponseDTO = VaccinationCenterTransformer.CenterToCenterResponseDto(doctor.getVaccinationCenter());
        return DoctorResponseDTO.builder()
                .name(doctor.getName())
                .emailId(doctor.getEmailId())
                .mobNo(doctor.getMobNo())
                .centerResponseDTO(centerResponseDTO)
                .build();
    }
}
