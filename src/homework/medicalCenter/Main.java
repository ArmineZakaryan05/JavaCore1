package homework.medicalCenter;

import homework.medicalCenter.model.Doctor;
import homework.medicalCenter.model.Patient;
import homework.medicalCenter.storage.DoctorStorage;
import homework.medicalCenter.storage.PatientStorage;
import homework.medicalCenter.util.DateUtil;

import java.util.Date;
import java.util.Scanner;


public class Main implements Commands {

    private static Scanner scanner = new Scanner(System.in);
    private static DoctorStorage doctorStorage = new DoctorStorage();
    private static PatientStorage patientStorage = new PatientStorage();

    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
            Commands.printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_DOCTOR:
                    addDoctor();
                    break;
                case SEARCH_DOCTOR_BY_PROFESSION:
                    searchDoctorByProfession();
                    break;
                case DELETE_DOCTOR_BY_ID:
                    deleteDoctorById();
                    break;
                case CHANGE_DOCTOR_BY_ID:
                    changeDoctorById();
                    break;
                case ADD_PATIENT:
                    addPatient();
                    break;
                case PRINT_ALL_PATIENTS_BY_DOCTOR:
                    printAllPatientsByDoctor();
                    break;
                case PRINT_ALL_PATIENTS:
                    patientStorage.print();
                    break;
                default:
                    System.err.println("Wrong command!");
            }
        }
    }


    private static void printAllPatientsByDoctor() {
        doctorStorage.print();
        System.out.println("Please choose doctor Id");
        String doctorId = scanner.nextLine();
        Doctor doctor = doctorStorage.getDoctorById(doctorId);
        if (doctor != null) {
            boolean foundPatients = patientStorage.printAllPatientsByDoctor(doctor);

            if (!foundPatients) {
                System.out.println("No patients found for Doctor " + doctor.getName() + " (ID: " + doctorId + ").");
            }
        } else {
            System.out.println("Doctor with ID " + doctorId + " not found.  Please try again.");
        }
    }


    private static void addPatient() {
        doctorStorage.print();
        System.out.println("Please choose doctor Id");
        String doctorId = scanner.nextLine();
        Doctor doctor = doctorStorage.getDoctorById(doctorId);

        if (doctor != null) {
            System.out.println("Please input patient id, name, surname, phone");
            String patientDataStr = scanner.nextLine();
            String[] patientDataArr = patientDataStr.split(",");
            if (patientDataArr.length == 4) {
                String id = patientDataArr[0];
                String name = patientDataArr[1];
                String surname = patientDataArr[2];
                String phone = patientDataArr[3];


                Patient patient = new Patient(id, name, surname, phone, doctor, new Date());

                patientStorage.add(patient);
                System.out.println("Patient added successfully! Registration Date and Time: "
                        + DateUtil.fromDateToString(new Date()));
            } else {
                System.out.println("Doctor with ID " + doctorId + " not found.");
            }
        }
    }

    private static void changeDoctorById() {
        doctorStorage.print();
        System.out.println("Please input doctor Id");
        String doctorId = scanner.nextLine();
        Doctor doctorById = doctorStorage.getDoctorById(doctorId);
        if (doctorById != null) {
            System.out.println("Please input doctor's new name");
            String name = scanner.nextLine();
            System.out.println("Please input doctor's new surname");
            String surname = scanner.nextLine();
            System.out.println("Please input doctor's new phone");
            String phone = scanner.nextLine();
            System.out.println("Please input doctor's new email");
            String email = scanner.nextLine();
            System.out.println("Please input doctor's new profession");
            String profession = scanner.nextLine();
            if (name != null && !name.isEmpty()) {
                doctorById.setName(name);
            }

            if (surname != null && !surname.isEmpty()) {
                doctorById.setSurname(surname);
            }
            if (email != null && !email.isEmpty()) {
                doctorById.setEmail(email);
            }
            if (phone != null && !phone.isEmpty()) {
                doctorById.setPhone(phone);
            }
            if (profession != null && !profession.isEmpty()) {
                doctorById.setProfession(profession);
            }
            System.out.println("Change was successfully");
        }
    }


    private static void deleteDoctorById() {
        doctorStorage.print();
        System.out.println("Please input doctor Id");
        String doctorId = scanner.nextLine();
        Doctor doctorById = doctorStorage.getDoctorById(doctorId);
        if (doctorById == null) {
            System.err.println("Doctor with " + doctorId + " Id does not exists!");
        } else {
            doctorStorage.deleteDoctorById(doctorId);
            System.out.println("Doctor deleted!");
        }
    }

    private static void searchDoctorByProfession() {
        doctorStorage.print();
        System.out.println("Please choose doctor profession");
        String doctorProfession = scanner.nextLine();
        doctorStorage.searchByProfession(doctorProfession);
    }

    private static void addDoctor() {
        System.out.println("Please input doctor id, name, surname, email, phone, profession");
        String doctorDataStr = scanner.nextLine();
        String[] doctorDataArr = doctorDataStr.split(",");
        if (doctorDataArr.length == 6) {
            String id = doctorDataArr[0];
            if (doctorStorage.getDoctorById(id) == null) {
                Doctor doctor = new Doctor();
                doctor.setId(id);
                doctor.setName(doctorDataArr[1]);
                doctor.setSurname(doctorDataArr[2]);
                doctor.setEmail(doctorDataArr[3]);
                doctor.setPhone(doctorDataArr[4]);
                doctor.setProfession(doctorDataArr[5]);
                doctorStorage.add(doctor);
                System.out.println("Doctor added!");

            } else {
                System.err.println("Doctor with " + id + " id already exists!");
            }
        }
    }
}
