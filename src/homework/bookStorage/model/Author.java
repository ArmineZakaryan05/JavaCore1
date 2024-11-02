package homework.bookStorage.model;

import homework.bookStorage.util.DateUtil;

import java.util.Date;
import java.util.Objects;

public class Author {

    private String id;
    private String name;
    private String surname;
    private String phone;
    private Date dateOfBirthday;
    private Gender gender;

    public Author(String id, String name, String surname, String phone, Date dateOfBirthday, Gender gender) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.dateOfBirthday = dateOfBirthday;
        this.gender = gender;
    }

    public Author() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(Date dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;
        return Objects.equals(id, author.id) && Objects.equals(name, author.name) && Objects.equals(surname, author.surname) && Objects.equals(phone, author.phone) && Objects.equals(dateOfBirthday, author.dateOfBirthday) && gender == author.gender;
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(surname);
        result = 31 * result + Objects.hashCode(phone);
        result = 31 * result + Objects.hashCode(dateOfBirthday);
        result = 31 * result + Objects.hashCode(gender);
        return result;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", dateOfBirthday=" + DateUtil.fromDateToString(dateOfBirthday) +
                ", gender=" + gender +
                '}';
    }
}