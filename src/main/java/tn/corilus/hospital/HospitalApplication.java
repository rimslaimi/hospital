package tn.corilus.hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import tn.corilus.hospital.entities.*;
import tn.corilus.hospital.repositories.AppointmentRepository;
import tn.corilus.hospital.repositories.ConsultationRepository;
import tn.corilus.hospital.repositories.DoctorRepository;
import tn.corilus.hospital.repositories.PatientRepository;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {
//  @Autowired
//   private DoctorRepository doctorRepository;
    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }
    @Bean
  CommandLineRunner init(DoctorRepository doctorRepository,
                         PatientRepository patientRepository,
                         AppointmentRepository appointmentRepository,
                         ConsultationRepository consultationRepository){// injection par constructeur
        return args -> {

            //doctorRepository.save(new Doctor("Rim", new Date(),4000,true));
//            Doctor doctor=doctorRepository.findById(1L).orElse(null);
//            System.out.println(doctor.getName());
//            for (int i =0; i <100 ; i++) {
//                doctorRepository.save(new Doctor("brahim", new Date(),(int)(Math.random()*1000),Math.random()>0.5));
//            }
//           // List<Doctor> doctorList=doctorRepository.findAll();
//            Page<Doctor> doctorList=doctorRepository.findAll(PageRequest.of(0,5));
//            System.out.println("nombre total des éléments \t"+doctorList.getTotalElements());
//            System.out.println("nombre d'element dans une page \t"+doctorList.getNumberOfElements());
//            System.out.println("nombre des pages \t"+doctorList.getTotalPages());
//            //List<Doctor> listD=doctorList.getContent();
//            doctorList.forEach(p->{
//                System.out.println("doctor id "+p.getId());
//                System.out.println("doctor salary "+p.getSalary());
//            });
//
//           // List<Doctor> d=doctorRepository.findDoctorByDisponible(true);
//           // List<Doctor> d=doctorRepository.findDoctorBySalaryBetween(300,500);
//            List<Doctor> d=doctorRepository.chercherDocteur(500,PageRequest.of(0,10));
//            d.forEach(p->{
//                System.out.println("doctor id "+p.getId());
//                //System.out.println("doctor salary "+p.getSalary());
//            });
//
//        };
            Stream.of("brahim","rym","wejden").forEach((name->{
                Doctor doctor=new Doctor();
                doctor.setName(name);
                doctor.setDisponible(Math.random()>0.5);
                doctor.setSalary((int)(Math.random()*100));
                doctorRepository.save(doctor);

            }));
            Stream.of("ouala","sarra","taymour").forEach((name->{
                Patient patient =new Patient();
                patient.setName(name);
                patient.setEmail(name+"@gamil.com");
                patient.setGender(Gender.FEMALE);
                patientRepository.save(patient);

            }));

            Patient patient=patientRepository.findById(2L).orElse(null);
            Doctor doctor=doctorRepository.findById(1l).orElseThrow(()->new RuntimeException(new Exception("Patient not found")));
            Appointment appointment=new Appointment();
            appointment.setDoctor(doctor);
            appointment.setPatient(patient);
            appointment.setStatus(Status.CONFIRMED);
            appointment.setDateAppointment(new Date());
            appointment.setTimeAppointment(new Date());
            appointmentRepository.save(appointment);



            Appointment app=appointmentRepository.findById(1L).orElse(null);
            Consultation consultation=new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setReport("fever");
            consultation.setAppointment(app);
            app.setConsultation(consultation);
            consultationRepository.save(consultation);

  };
//    @Override
//    public void run(String... args) throws Exception {
//        doctorRepository.save(new Doctor("brahim", new Date(),true));
//
//    }
}}
