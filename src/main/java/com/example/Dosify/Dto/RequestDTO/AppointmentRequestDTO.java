package com.example.Dosify.Dto.RequestDTO;

import com.example.Dosify.Enums.DoseNo;
import com.example.Dosify.Enums.VaccineType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppointmentRequestDTO {
    DoseNo doseNo;
    int userId;
    int doctorId;
    VaccineType vaccineType;
}
