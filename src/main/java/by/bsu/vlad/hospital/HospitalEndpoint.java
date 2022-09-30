package by.bsu.vlad.hospital;

import by.bsu.vlad.hospital.controllers.HospitalController;
import by.bsu.vlad.hospital.entities.*;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class HospitalEndpoint {
    @WebMethod
    public Hospital getHospitalInfo() {
        return HospitalController.getHospital();
    }

    @WebMethod
    public Patient[] getPatients() {
        return HospitalController.getPatients();
    }

    @WebMethod
    public Doctor[] getDoctors() {
        return HospitalController.getDoctors();
    }

    @WebMethod
    public Patient getPatient(@WebParam(name = "id") String id) {
        return HospitalController.getPatient(id);
    }

    @WebMethod
    public Doctor getDoctor(@WebParam(name = "id") String id) {
        return HospitalController.getDoctor(id);
    }

    @WebMethod
    public Patient addPatient(@WebParam(name = "name") String name, @WebParam(name = "surname") String surname) {
        return HospitalController.addPatient(name, surname);
    }

    @WebMethod
    public Doctor updateDoctorSpecialization(@WebParam(name = "id") String id,
                                @WebParam(name = "specialization") Specialization specialization) {
        return HospitalController.updateDoctorSpecialization(id, specialization);
    }

    @WebMethod
    public boolean fireDoctor(@WebParam(name = "id") String id) {
        return HospitalController.fireDoctor(id);
    }

    @WebMethod
    public BloodType getPatientBloodType(@WebParam(name = "id") String id) {
        return HospitalController.getPatientBloodType(id);
    }

    @WebMethod
    public AmbulanceCard updateDonorStatus(@WebParam(name = "id") String id, @WebParam(name = "isDonor") boolean isDonor) {
        return HospitalController.updateDonorStatus(id, isDonor);
    }
}
