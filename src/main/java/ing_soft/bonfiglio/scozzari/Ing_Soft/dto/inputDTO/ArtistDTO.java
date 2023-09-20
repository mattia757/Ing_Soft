package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class ArtistDTO {
    private String firstName;
    private String lastName;
    private String gender;
    private String birthDate;
    private String birthPlace;
    private String birthCountry;
    private String educationTitle;
    private String email;
    private boolean isStudent;
    private Long id;

    public ArtistDTO(String firstName, String lastName, String gender, String birthDate, String birthPlace, String birthCountry, String educationTitle, String email, boolean isStudent, Long id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.birthCountry = birthCountry;
        this.educationTitle = educationTitle;
        this.email = email;
        this.isStudent = isStudent;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public String getEducationTitle() {
        return educationTitle;
    }

    public String getEmail() {
        return email;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public Long getId() {
        return id;
    }
}
