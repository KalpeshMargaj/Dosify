package com.example.Dosify.Dto.ResponseDTO;

import com.example.Dosify.Enums.DoseNo;
import com.example.Dosify.Enums.VaccineType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AppointmentResponseDTO {
    String userName;

    String doctorName;

    String appointmentNo;

    Date dateOfAppointment;

    VaccineType vaccineType;

    DoseNo doseNo;

    CenterResponseDTO centerResponseDTO;

}
