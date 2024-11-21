package com.example.Dosify.Model;

import com.example.Dosify.Enums.DoseNo;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "appointment")
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "appointment_no")
    String appointmentNo;

    @Column(name = "date")
            @CreationTimestamp
    Date dateOfAppointment;

    @Enumerated(EnumType.STRING)
            @Column(name = "dose_no")
    DoseNo doseNo;

    @ManyToOne
    @JoinColumn
    User user;

    @ManyToOne
    Doctor doctor;

}
