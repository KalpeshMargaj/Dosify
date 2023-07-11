package com.example.Dosify.dto.responseDTO;

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
