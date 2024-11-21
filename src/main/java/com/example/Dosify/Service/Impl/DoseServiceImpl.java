package com.example.Dosify.Service.Impl;

import com.example.Dosify.Enums.VaccineType;
import com.example.Dosify.Model.Dose;
import com.example.Dosify.Model.User;
import com.example.Dosify.Service.DoseService;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class DoseServiceImpl implements DoseService {
    @Override
    public Dose createDose(User user, VaccineType vaccineType) {
        return Dose.builder()
                .doseId(String.valueOf(UUID.randomUUID()))
                .vaccineType(vaccineType)
                .user(user)
                .build();
    }
}
