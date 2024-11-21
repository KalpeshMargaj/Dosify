package com.example.Dosify.Controller;

import com.example.Dosify.Dto.RequestDTO.AppointmentRequestDTO;
import com.example.Dosify.Dto.ResponseDTO.AppointmentResponseDTO;
import com.example.Dosify.Exception.DoctorNotFoundException;
import com.example.Dosify.Exception.Dose2IsAlreadyTaken;
import com.example.Dosify.Exception.NotEligibleForDoseException;
import com.example.Dosify.Exception.UserNotFoundException;
import com.example.Dosify.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")

public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/book")
    public ResponseEntity<AppointmentResponseDTO> bookAppointment(@RequestBody AppointmentRequestDTO appointmentRequestDTO) throws UserNotFoundException, DoctorNotFoundException, Dose2IsAlreadyTaken, NotEligibleForDoseException {
        AppointmentResponseDTO appointmentResponseDTO = appointmentService.bookAppointment(appointmentRequestDTO);
        return new ResponseEntity<>(appointmentResponseDTO, HttpStatus.CREATED);
    }
}
