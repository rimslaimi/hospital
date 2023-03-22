package tn.corilus.hospital.sevices;

import org.springframework.stereotype.Service;
import tn.corilus.hospital.entities.Appointment;
import tn.corilus.hospital.entities.Consultation;
import tn.corilus.hospital.entities.Doctor;
import tn.corilus.hospital.entities.Patient;
import tn.corilus.hospital.repositories.AppointmentRepository;
import tn.corilus.hospital.repositories.ConsultationRepository;
import tn.corilus.hospital.repositories.DoctorRepository;
import tn.corilus.hospital.repositories.PatientRepository;

import java.util.List;
@Service
public class HospitalServiceImpl implements HospitalService{

    private DoctorRepository doctorRepository;
    private AppointmentRepository appointmentRepository;
    private ConsultationRepository consultationRepository;
    private PatientRepository patientRepository;

    public HospitalServiceImpl(DoctorRepository doctorRepository, AppointmentRepository appointmentRepository, ConsultationRepository consultationRepository, PatientRepository patientRepository) {
        this.doctorRepository = doctorRepository;
        this.appointmentRepository = appointmentRepository;
        this.consultationRepository = consultationRepository;
        this.patientRepository = patientRepository;
    }
    @Override
    public Doctor saveDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public Appointment appointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient retrievePatient(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

}
