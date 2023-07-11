package com.example.Dosify.Controller;

import com.example.Dosify.dto.requestDTO.AppointmentRequestDTO;
import com.example.Dosify.dto.responseDTO.AppointmentResponseDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    public AppointmentResponseDTO bookAppointment(@RequestBody AppointmentRequestDTO appointmentRequestDTO)
    {
            return null;
    }
}
