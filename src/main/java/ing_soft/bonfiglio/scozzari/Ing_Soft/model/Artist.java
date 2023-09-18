package ing_soft.bonfiglio.scozzari.Ing_Soft.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Artist extends User{

    // Aggiungi gli attributi corrispondenti agli input del frontend
    @NotBlank(message = "Il nome non può essere vuoto o null")
    private String firstName;

    @NotBlank(message = "Il cognome non può essere vuoto o null")
    private String lastName;

    @NotBlank(message = "Il genere non può essere vuoto o null")
    private String gender;

    @NotBlank(message = "La data di nascita non può essere vuota o null")
    private String birthDate;

    @NotBlank(message = "Il luogo di nascita non può essere vuoto o null")
    private String birthPlace;

    @NotBlank(message = "Lo stato di nascita non può essere vuoto o null")
    private String birthCountry;

    @NotBlank(message = "Il titolo di studio non può essere vuoto o null")
    private String educationTitle;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "L'email non può essere vuota o null")
    @Email(message = "L'email deve rispettare il formato")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:.[a-zA-Z0-9-]+)*$")
    private String email;

    private boolean isStudent;
    @Id
    private Long id;

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public String getEducationTitle() {
        return educationTitle;
    }

    public void setEducationTitle(String educationTitle) {
        this.educationTitle = educationTitle;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
