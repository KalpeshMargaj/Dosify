package com.example.Dosify.Dto.RequestDTO;

import com.example.Dosify.Enums.CenterType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class CenterRequestDTO {

    String name;

    String location;

    CenterType centerType;
}
