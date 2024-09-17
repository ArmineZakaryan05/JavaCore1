package homework.medicalCenter.storage;

import homework.medicalCenter.model.Doctor;


public class DoctorStorage {

    private Doctor[] doctors = new Doctor[10];
    private int size;

    public void add(Doctor doctor) {
        if (doctors.length == size) {
            extendStorage();
        }
        doctors[size++] = doctor;
    }

    private void extendStorage() {
        Doctor[] tmp = new Doctor[size + 10];
        System.arraycopy(doctors, 0, tmp, 0, size);
        doctors = tmp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(doctors[i]);
        }
    }

    public Doctor getDoctorById(String id) {
        for (int i = 0; i < size; i++) {
            if (doctors[i].getId().equals(id)) {
                return doctors[i];
            }
        }
        return null;
    }

    public Doctor getDoctorByProfession(String doctorProfession) {
        for (int i = 0; i < size; i++) {
            if (doctors[i].getProfession().equals(doctorProfession)) ;
            return doctors[i];
        }
        return null;
    }

    public void searchByProfession(String profession) {
        boolean found = false;

        for (int i = 0; i < size; i++) {
            if (doctors[i].getProfession().equals(profession)) {
                System.out.println(doctors[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Doctor with " + profession + " profession does  not found!");
        }
    }

    public void deleteDoctorById(String doctorId) {
        int index = getDoctorIndexById(doctorId);
        if (index != -1) {
            for (int i = index + 1; i < size; i++) {
                doctors[i - 1] = doctors[i];
            }
            size--;
        }
    }

    private int getDoctorIndexById(String doctorId) {
        for (int i = 0; i < size; i++) {
            if (doctors[i].getId().equals(doctorId)) {
                return i;
            }
        }
        return -1;
    }
}
