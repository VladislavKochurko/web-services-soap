package by.bsu.vlad.hospital.entities;

import java.util.UUID;

public class Patient extends BasePerson {
    private final String ambulanceCardId = UUID.randomUUID().toString();;
    public Patient(String name, String surname) {
        super(name, surname);
    }

    public String getAmbulanceCardId() {
        return ambulanceCardId;
    }
}
