package tn.corilus.hospital.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Temporal(TemporalType.DATE)
    private Date dateAppointment;
    @Temporal(TemporalType.TIME)
    private Date timeAppointment;
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Patient patient;
    @OneToOne(mappedBy = "appointment",cascade =CascadeType.REMOVE)
    private  Consultation consultation;

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateAppointment() {
        return dateAppointment;
    }

    public void setDateAppointment(Date dateAppointment) {
        this.dateAppointment = dateAppointment;
    }

    public Date getTimeAppointment() {
        return timeAppointment;
    }

    public void setTimeAppointment(Date timeAppointment) {
        this.timeAppointment = timeAppointment;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Appointment() {
    }

    public Appointment(long id, Date dateAppointment, Date timeAppointment, Status status) {
        this.id = id;
        this.dateAppointment = dateAppointment;
        this.timeAppointment = timeAppointment;
        this.status = status;
    }
}
