package com.example.Dosify.Service;

import com.example.Dosify.Dto.RequestDTO.AppointmentRequestDTO;
import com.example.Dosify.Dto.ResponseDTO.AppointmentResponseDTO;
import com.example.Dosify.Exception.DoctorNotFoundException;
import com.example.Dosify.Exception.Dose2IsAlreadyTaken;
import com.example.Dosify.Exception.NotEligibleForDoseException;
import com.example.Dosify.Exception.UserNotFoundException;

public interface AppointmentService {
    public AppointmentResponseDTO bookAppointment(AppointmentRequestDTO appointmentRequestDTO) throws UserNotFoundException, DoctorNotFoundException, NotEligibleForDoseException, Dose2IsAlreadyTaken;
}
