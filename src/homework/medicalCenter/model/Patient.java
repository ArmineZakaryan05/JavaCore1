package homework.medicalCenter.model;

import homework.bookStorage.util.DateUtil;

import java.util.Date;
import java.util.Objects;

public class Patient extends Person{

    private Doctor doctor;
    private Date registerDateTime;

    public Patient(String id, String name, String surname, String phone, Doctor doctor, Date registerDateTime) {
        super(id, name, surname, phone);
        this.doctor = doctor;
        this.registerDateTime = registerDateTime;
    }

    public Patient() {
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getRegisterDateTime() {
        return registerDateTime;
    }

    public void setRegisterDateTime(Date registerDateTime) {
        this.registerDateTime = registerDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Patient patient = (Patient) o;
        return Objects.equals(doctor, patient.doctor) && Objects.equals(registerDateTime, patient.registerDateTime);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(doctor);
        result = 31 * result + Objects.hashCode(registerDateTime);
        return result;
    }

    @Override
    public String toString() {

        return  super.toString() + "Patient{" +
                "doctor='" + doctor + '\'' +
                ", registerDateTime=" + DateUtil.fromDateToString(registerDateTime) +
                '}';
    }
}
