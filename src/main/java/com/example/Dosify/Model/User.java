package com.example.Dosify.Model;

import com.example.Dosify.Enums.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "user")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;

    @Column(name = "name")
    String name;

    @Column(name = "age")
    int age;

    @Column(name = "email_id")
    String emailId;

    @Column(name = "mob_no",length = 10)
    String mobNo;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    Gender gender;

    @Column(name = "is_dose1_taken")
    boolean isDose1Taken;

    @Column(name = "is_dose2_taken")
    boolean isDose2Taken;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
List<Appointment> appointmentList = new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Dose> doses = new ArrayList<>();
}
