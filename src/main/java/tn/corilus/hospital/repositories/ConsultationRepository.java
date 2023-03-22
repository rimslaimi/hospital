package tn.corilus.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.corilus.hospital.entities.Consultation;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
