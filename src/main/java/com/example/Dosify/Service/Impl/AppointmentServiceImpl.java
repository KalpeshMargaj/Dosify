package com.example.Dosify.Service.Impl;

import com.example.Dosify.Dto.RequestDTO.AppointmentRequestDTO;
import com.example.Dosify.Dto.ResponseDTO.AppointmentResponseDTO;
import com.example.Dosify.Dto.ResponseDTO.CenterResponseDTO;
import com.example.Dosify.Enums.DoseNo;
import com.example.Dosify.Exception.DoctorNotFoundException;
import com.example.Dosify.Exception.Dose2IsAlreadyTaken;
import com.example.Dosify.Exception.NotEligibleForDoseException;
import com.example.Dosify.Exception.UserNotFoundException;
import com.example.Dosify.Model.*;
import com.example.Dosify.Repository.DoctorRepository;
import com.example.Dosify.Repository.UserRepository;
import com.example.Dosify.Service.AppointmentService;
import com.example.Dosify.Service.DoseService;
import com.example.Dosify.Transformers.AppointmentTransformer;
import com.example.Dosify.Transformers.VaccinationCenterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    DoseService doseService;

    @Override
    public AppointmentResponseDTO bookAppointment(AppointmentRequestDTO appointmentRequestDTO) throws UserNotFoundException, DoctorNotFoundException, NotEligibleForDoseException, Dose2IsAlreadyTaken {
        Optional<User> optionalUser  = userRepository.findById(appointmentRequestDTO.getUserId());
        if(!optionalUser.isPresent())
        {
            throw new UserNotFoundException("User not found.");
        }
        User user = optionalUser.get();

        Optional<Doctor> optionalDoctor  = doctorRepository.findById(appointmentRequestDTO.getDoctorId());
        if(!optionalDoctor.isPresent())
        {
            throw new DoctorNotFoundException("Doctor not found.");
        }
        Doctor doctor = optionalDoctor.get();

        if(appointmentRequestDTO.getDoseNo() == DoseNo.DOSE1)
        {
            user.setDose1Taken(true);
        }else{
            if(!user.isDose1Taken())
            {
                throw new NotEligibleForDoseException("Dose1 is not taken by you. " +
                        "You will be eligible for dose 2 after completion of dose 1.");
            }else if(user.isDose2Taken())
            {
                throw new Dose2IsAlreadyTaken("You have already taken dose 2.");
            }
            user.setDose2Taken(true);
        }

        Dose dose = doseService.createDose(user, appointmentRequestDTO.getVaccineType());
        user.getDoses().add(dose);

        Appointment appointment = AppointmentTransformer.AppointmentRequestDtoToAppointment(appointmentRequestDTO);
        appointment.setUser(user);
        appointment.setDoctor(doctor);

        user.getAppointmentList().add(appointment);
        User savedUser = userRepository.save(user); // as parent class will also save dose and appointment rather than saving appointment.

        List<Appointment> appointmentList = savedUser.getAppointmentList();
        Appointment savedAppointment =  appointmentList.get(appointmentList.size() -1);
        doctor.getAppointmentList().add(savedAppointment);

        AppointmentResponseDTO appointmentResponseDTO = AppointmentTransformer.AppointmentToAppointmentResponseDto(savedAppointment);
        CenterResponseDTO centerResponseDTO = VaccinationCenterTransformer.CenterToCenterResponseDto(doctor.getVaccinationCenter());

        appointmentResponseDTO.setUserName(user.getName());
        appointmentResponseDTO.setDoctorName(doctor.getName());
        appointmentResponseDTO.setVaccineType(appointmentRequestDTO.getVaccineType());
        appointmentResponseDTO.setCenterResponseDTO(centerResponseDTO);

        return appointmentResponseDTO;
    }
}
