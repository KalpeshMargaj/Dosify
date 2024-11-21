package com.example.Dosify.Dto.RequestDTO;

import com.example.Dosify.Enums.Gender;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class UserRequestDTO {
    String name;

    int age;

    String emailId;

    String mobNo;

    Gender gender;
}
