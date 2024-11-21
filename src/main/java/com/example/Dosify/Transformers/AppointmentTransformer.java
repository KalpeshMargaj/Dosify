package com.example.Dosify.Transformers;

import com.example.Dosify.Dto.RequestDTO.AppointmentRequestDTO;
import com.example.Dosify.Dto.ResponseDTO.AppointmentResponseDTO;
import com.example.Dosify.Model.Appointment;
import lombok.experimental.UtilityClass;

import java.util.UUID;
@UtilityClass
public class AppointmentTransformer {
    public static Appointment AppointmentRequestDtoToAppointment(AppointmentRequestDTO appointmentRequestDTO)
    {
        return Appointment.builder()
                .appointmentNo(String.valueOf(UUID.randomUUID()))
                .doseNo(appointmentRequestDTO.getDoseNo())
                .build();
    }

    public static AppointmentResponseDTO AppointmentToAppointmentResponseDto(Appointment appointment)
    {
        return AppointmentResponseDTO.builder()
                .appointmentNo(appointment.getAppointmentNo())
                .dateOfAppointment(appointment.getDateOfAppointment())
                .doseNo(appointment.getDoseNo())
                .build();
    }
}
