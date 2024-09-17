package homework.medicalCenter.storage;

import homework.medicalCenter.model.Doctor;
import homework.medicalCenter.model.Patient;

public class PatientStorage {

    private Patient[] patients = new Patient[10];
    private int size;

    public void add(Patient patient) {
        if (patients.length == size) {
            extendStorage();
        }
        patients[size++] = patient;
    }

    private void extendStorage() {
        Patient[] tmp = new Patient[size + 10];
        System.arraycopy(patients, 0, tmp, 0, size);
        patients = tmp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(patients[i]);
        }
    }


    public boolean printAllPatientsByDoctor(Doctor doctor) {
        if (doctor == null) {
            System.out.println("Invalid doctor.");
            return true;
        }

        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (patients[i] != null && patients[i].getDoctor() != null && patients[i].getDoctor().getId().equals(doctor.getId())) {
                System.out.println(patients[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No patients found for Doctor " + doctor.getId());
        }
        return found;
    }
}

