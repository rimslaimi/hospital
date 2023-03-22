package tn.corilus.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.corilus.hospital.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> {

}
