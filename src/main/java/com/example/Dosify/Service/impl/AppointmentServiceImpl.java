package com.example.Dosify.Service.impl;

import com.example.Dosify.Enum.DoseNo;
import com.example.Dosify.Model.Doctor;
import com.example.Dosify.Model.Dose1;
import com.example.Dosify.Model.Dose2;
import com.example.Dosify.Model.User;
import com.example.Dosify.Repository.DoctorRepository;
import com.example.Dosify.Repository.UserRepository;
import com.example.Dosify.Service.AppointmentService;
import com.example.Dosify.Service.Dose1Service;
import com.example.Dosify.Service.Dose2Service;
import com.example.Dosify.dto.requestDTO.AppointmentRequestDTO;
import com.example.Dosify.dto.requestDTO.UserRequestDTO;
import com.example.Dosify.dto.responseDTO.AppointmentResponseDTO;
import com.example.Dosify.exception.DoctorNotFoundException;
import com.example.Dosify.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    Dose1Service dose1Service;
    @Autowired
    Dose2Service dose2Service;

    @Override
    public AppointmentResponseDTO bookAppointment(AppointmentRequestDTO appointmentRequestDTO) throws UserNotFoundException, DoctorNotFoundException {
        Optional<User> optionalUser = userRepository.findById(appointmentRequestDTO.getUserId());
        if(!optionalUser.isPresent())
        {
            throw new UserNotFoundException("User doesn't exit!");
        }

        Optional<Doctor> optionalDoctor = doctorRepository.findById(appointmentRequestDTO.getDoctorId());
        if(!optionalDoctor.isPresent())
        {
            throw new DoctorNotFoundException("Doctor doesn't exit!");
        }

        User user = optionalUser.get();
        Doctor doctor = optionalDoctor.get();

        if(appointmentRequestDTO.getDoseNo() == DoseNo.DOSE1)
        {
            Dose1 dose1 = dose1Service.createDose1(user,appointmentRequestDTO.getVaccineType());
            user.setDose2Taken(true);
            user.setDose1(dose1);
        }
        else
        {

        }


        return null;
    }
}
