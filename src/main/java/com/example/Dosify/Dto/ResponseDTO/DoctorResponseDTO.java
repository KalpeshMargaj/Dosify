package com.example.Dosify.Dto.ResponseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class DoctorResponseDTO {

    String name;

    String emailId;

    String mobNo;

    CenterResponseDTO centerResponseDTO;



}
