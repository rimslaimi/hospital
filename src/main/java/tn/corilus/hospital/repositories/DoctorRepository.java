package tn.corilus.hospital.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.corilus.hospital.entities.Doctor;


import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {

   List<Doctor> findDoctorByDisponible(boolean isDisponible);
   List<Doctor> findDoctorBySalaryBetween(int inf,int sup);
   @Query("SELECT d FROM Doctor d WHERE d.salary > :x")//jpql
   List<Doctor> chercherDocteur(@Param("x")int salary, Pageable pageable);
}
