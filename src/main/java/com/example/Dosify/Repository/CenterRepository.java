package com.example.Dosify.Repository;


import com.example.Dosify.Model.VaccinationCenter;
import com.example.Dosify.Service.VaccinationCenterService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CenterRepository extends JpaRepository<VaccinationCenter,Integer> {
}
