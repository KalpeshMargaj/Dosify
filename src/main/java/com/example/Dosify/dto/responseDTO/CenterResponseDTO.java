package com.example.Dosify.dto.responseDTO;

import com.example.Dosify.Enum.CenterType;
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
    CenterType centerType;
}
