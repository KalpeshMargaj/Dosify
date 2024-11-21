package com.example.Dosify.Service;

import com.example.Dosify.Enums.VaccineType;
import com.example.Dosify.Model.Dose;
import com.example.Dosify.Model.User;

public interface DoseService {
    public Dose createDose(User user, VaccineType vaccineType);
}
