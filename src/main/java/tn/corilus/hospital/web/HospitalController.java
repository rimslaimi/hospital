package tn.corilus.hospital.web;

import jakarta.servlet.Servlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tn.corilus.hospital.entities.Patient;
import tn.corilus.hospital.sevices.HospitalService;

import java.net.URI;
import java.util.List;

@RestController
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;

    @GetMapping("/patients")
    public List<Patient> getPatient(){
        return hospitalService.getAllPatients();
    }
    @PostMapping("/patients")


    public ResponseEntity<Patient> savePatient(@RequestBody Patient newPatient) {
        Patient createdPatient=hospitalService.savePatient(newPatient);
      //  URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(createdPatient.getId());
      //  HttpHeaders headers=new HttpHeaders();
        //headers.setLocation(location);
        //return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(newPatient); OU
        URI location =ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdPatient.getId())
                .toUri();
        return  ResponseEntity.created(location).body(createdPatient);
    }
    @GetMapping("/patients/{id}")
    public ResponseEntity<Patient>findPatient(@PathVariable Long id){
        Patient foundPatient=hospitalService.retrievePatient(id);
        if(foundPatient==null){
            return  ResponseEntity.notFound().build();
        } else {
            return  ResponseEntity.ok().body(foundPatient);
        }
    }
    @DeleteMapping("/patients/{id}")
    public void deletePatient(@PathVariable("id") Long id){
        hospitalService.deletePatient(id);
    }
}

