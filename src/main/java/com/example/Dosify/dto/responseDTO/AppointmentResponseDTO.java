package com.example.Dosify.dto.responseDTO;

import com.example.Dosify.Enum.DoseNo;
import com.example.Dosify.Enum.VaccineType;
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
    String appointmentNo;

    Date dateOfAppointment;

    DoseNo doseNo;

    CenterResponseDTO centerResponseDTO;

    String doctorName;
    VaccineType vaccineType;
}
