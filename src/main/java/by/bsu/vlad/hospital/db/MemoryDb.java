package by.bsu.vlad.hospital.db;

import by.bsu.vlad.hospital.entities.*;
import by.bsu.vlad.hospital.helpers.Helper;

import java.util.ArrayList;
import java.util.Arrays;


public class MemoryDb {
    private static final ArrayList<Patient> patients = new ArrayList<>(Arrays.asList(
            new Patient("Name1", "Surname1"),
            new Patient("Name2", "Surname2"),
            new Patient("Name3", "Surname3"),
            new Patient("Name4", "Surname4"),
            new Patient("Name5", "Surname5")
    ));

    private static final ArrayList<Doctor> doctors = new ArrayList<>(Arrays.asList(
            new Doctor("Name1", "Surname1", Specialization.Otolaryngologist),
            new Doctor("Name2", "Surname2", Specialization.Surgeon),
            new Doctor("Name3", "Surname3", Specialization.Psychologist),
            new Doctor("Name4", "Surname4", Specialization.Otolaryngologist),
            new Doctor("Name5", "Surname5", Specialization.Surgeon)
    ));

    private static final ArrayList<AmbulanceCard> ambulanceCards = new ArrayList<>(Arrays.asList(
            new AmbulanceCard(BloodType.ABMinus, false),
            new AmbulanceCard(BloodType.ABPlus, true),
            new AmbulanceCard(BloodType.APlus, false),
            new AmbulanceCard(BloodType.BMinus, true),
            new AmbulanceCard(BloodType.OMinus, false)
    ));

    private static final Hospital hospital = new Hospital("ул. Сурганова 45", getPatients(), getDoctors());

    public static Hospital getHospital() {
        return hospital;
    }

    public static Patient[] getPatients() {
        return (Patient[]) patients.toArray();
    }

    public static Doctor[] getDoctors() {
        return (Doctor[]) doctors.toArray();
    }

    public static Patient getPatient(String id) {
        return Helper.getEntityById(patients, id);
    }

    public static Doctor getDoctor(String id) {
        return Helper.getEntityById(doctors, id);
    }


    public static Doctor updateDoctorSpecialization(Doctor doctor, Specialization specialization) {
        return doctor.updateSpecialization(specialization);
    }

    public static boolean firDoctorFromHospital(String id) {
        return hospital.fireDoctor(id);
    }

    public static BloodType getPatientBloodType(String id) {
        String ambulanceCardId = getPatient(id).getAmbulanceCardId();
        AmbulanceCard ambulanceCard =  ambulanceCards.stream()
                .filter(card -> card.getId().equals(ambulanceCardId))
                .findFirst()
                .orElse(null);

        return ambulanceCard.getBloodType();
    }
    public static AmbulanceCard updatePatientDonorStatus(String id, boolean isDonor) {
        String ambulanceCardId = getPatient(id).getAmbulanceCardId();
        AmbulanceCard ambulanceCard =  ambulanceCards.stream()
                .filter(card -> card.getId().equals(ambulanceCardId))
                .findFirst()
                .orElse(null);


        return ambulanceCard.updateDonorStatus(isDonor);
    }
}
