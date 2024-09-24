package homework.medicalCenter.model;

import java.util.Objects;

public class Doctor extends Person {

    private String email;
    private String profession;

    public Doctor(String id, String name, String surname, String phone, String email, String profession) {
        super(id, name, surname, phone);
        this.email = email;
        this.profession = profession;
    }

    public Doctor() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Doctor doctor = (Doctor) o;
        return Objects.equals(email, doctor.email) && Objects.equals(profession, doctor.profession);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(email);
        result = 31 * result + Objects.hashCode(profession);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "Doctor{" +
                "email='" + email + '\'' +
                ", profession='" + profession + '\'' +
                '}';
    }
}
