package by.bsu.vlad.hospital.controllers;

import by.bsu.vlad.hospital.db.MemoryDb;
import by.bsu.vlad.hospital.entities.*;

public class HospitalController {
    public static Hospital getHospital() {
        return MemoryDb.getHospital();
    }

    public static Patient[] getPatients() {
        return MemoryDb.getHospital().getPatients();
    }

    public static Doctor[] getDoctors() {
        return MemoryDb.getHospital().getDoctors();
    }

    public static Patient getPatient(String id) {
        if (id == null) {
            throw new RuntimeException("ID should be specified");
        }

        return MemoryDb.getPatient(id);
    }

    public static Doctor getDoctor(String id) {
        if (id == null) {
            throw new RuntimeException("ID should be specified");
        }

        return MemoryDb.getDoctor(id);
    }

    public static Patient addPatient(String name, String surname) throws RuntimeException {
        if (name == null) {
            throw new RuntimeException("Name should be specified");
        }

        if (surname == null) {
            throw new RuntimeException("Surname should be specified");
        }

        Patient patient = new Patient(name, surname);

        MemoryDb.getHospital().addPatient(patient);
        return patient;
    }

    public static Doctor updateDoctorSpecialization(String id, Specialization specialization) throws RuntimeException {
        if (id == null) {
            throw new RuntimeException("ID should be specified");
        }

        if (specialization == null) {
            throw new RuntimeException("Specialization should be specified");
        }

        Doctor doctor = MemoryDb.getDoctor(id);

        if (doctor == null) {
            throw new RuntimeException("Doctor with current id not found");
        }

        return MemoryDb.updateDoctorSpecialization(doctor, specialization);
    }

    public static boolean fireDoctor(String id) throws RuntimeException {
        if (id == null) {
            throw new RuntimeException("ID should be specified");
        }

        return MemoryDb.firDoctorFromHospital(id);
    }

    public static BloodType getPatientBloodType(String id) throws RuntimeException {
        if (id == null) {
            throw new RuntimeException("ID should be specified");
        }

        return MemoryDb.getPatientBloodType(id);
    }

    public static AmbulanceCard updateDonorStatus(String id, boolean isDonor) {
        if (id == null) {
            throw new RuntimeException("ID should be specified");
        }
        return MemoryDb.updatePatientDonorStatus(id, isDonor);
    }
}
