package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.subRegistrationMapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationDTO.SubRetiredDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationDTO.SubStudentDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Retired;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class SubStudentMapper {

    public static Student mapToStudent(SubStudentDTO subStudentDTO) {
        if (subStudentDTO == null) {
            return null;
        }

        Student student = new Student();
        student.setStudies(subStudentDTO.getStudies());

        return student;
    }

}
