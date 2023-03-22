package tn.corilus.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.corilus.hospital.entities.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}
