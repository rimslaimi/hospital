package tn.corilus.hospital.sevices;

import tn.corilus.hospital.entities.Appointment;
import tn.corilus.hospital.entities.Consultation;
import tn.corilus.hospital.entities.Doctor;
import tn.corilus.hospital.entities.Patient;

import java.util.List;

public interface HospitalService {
   Patient savePatient(Patient p);
   Doctor saveDoctor(Doctor appointment);
   Consultation saveConsultation(Consultation consultation);
   Appointment appointment(Appointment appointment);
   List<Patient> getAllPatients();
   Patient retrievePatient(Long id);
   Patient updatePatient(Patient patient);
    void deletePatient(Long id);
}
