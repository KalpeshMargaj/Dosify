package com.example.Dosify.Dto.RequestDTO;

import com.example.Dosify.Enums.Gender;
import lombok.*;
        import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DoctorRequestDTO {
    int centerId;

    String name;

    int age;

    String emailId;

    String mobNo;

    Gender gender;
}
