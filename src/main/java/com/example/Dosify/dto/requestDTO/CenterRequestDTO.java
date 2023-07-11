package com.example.Dosify.dto.requestDTO;

import com.example.Dosify.Enum.CenterType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CenterRequestDTO {
    String name;
    String location;
    CenterType centerType;
}
