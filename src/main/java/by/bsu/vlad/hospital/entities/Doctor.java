package by.bsu.vlad.hospital.entities;

public class Doctor extends BasePerson{
    private Specialization specialization;

    public Doctor(String name, String surname, Specialization specialization) {
        super(name, surname);
        this.specialization = specialization;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public Doctor updateSpecialization(Specialization specialization) {
        this.setSpecialization(specialization);
        return this;
    }
}
