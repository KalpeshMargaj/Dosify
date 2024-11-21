package com.example.Dosify.Dto.ResponseDTO;

import com.example.Dosify.Enums.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CenterResponseDTO {
    String name;

    String location;

    CenterType type;

}
