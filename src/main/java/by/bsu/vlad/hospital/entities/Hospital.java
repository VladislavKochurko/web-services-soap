package by.bsu.vlad.hospital.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hospital extends BaseEntity {
    private String address;
    private Patient[] patients;
    private Doctor[] doctors;

    public Hospital(String address, Patient[] patients, Doctor[] doctors) {
        this.address = address;
        this.patients = patients;
        this.doctors = doctors;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Patient[] getPatients() {
        return patients;
    }

    public void setPatients(Patient[] patients) {
        this.patients = patients;
    }

    public Doctor[] getDoctors() {
        return doctors;
    }

    public void setDoctors(Doctor[] doctors) {
        this.doctors = doctors;
    }

    public Patient[] addPatient(Patient patient) {
        List<Patient> patientsList
                = new ArrayList<Patient>(
                Arrays.asList(patients));
        patientsList.add(patient);
        patients = patientsList.toArray(patients);
        return patients;
    }

    public boolean fireDoctor(String id) {
        List<Doctor> doctorsList
                = new ArrayList<Doctor>(
                Arrays.asList(doctors));

        Doctor doctorToFire = doctorsList.stream()
                .filter(doctor -> doctor.getId().equals(id))
                .findFirst()
                .orElse(null);
        doctorsList.remove(doctorToFire);
        doctors = doctorsList.toArray(doctors);
        return doctorsList.remove(doctorToFire);
    }
}
