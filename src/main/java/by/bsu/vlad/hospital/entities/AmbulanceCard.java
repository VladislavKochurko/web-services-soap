package by.bsu.vlad.hospital.entities;

public class AmbulanceCard extends BaseEntity{
    private BloodType bloodType;
    private boolean isDonor;

    public AmbulanceCard(BloodType bloodType, boolean isDonor) {
        this.bloodType = bloodType;
        this.isDonor = isDonor;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public boolean isDonor() {
        return isDonor;
    }

    public void setDonor(boolean donor) {
        isDonor = donor;
    }

    public AmbulanceCard updateDonorStatus(boolean isDonor) {
        this.isDonor = isDonor;
        return this;
    }
}
