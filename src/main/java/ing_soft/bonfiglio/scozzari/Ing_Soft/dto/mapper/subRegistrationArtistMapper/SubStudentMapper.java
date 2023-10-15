package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.mapper.subRegistrationArtistMapper;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.InputDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.subRegistrationArtistDTO.SubStudentDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Student;
import org.springframework.stereotype.Component;

@Component
public class SubStudentMapper {

    public static Student subStudentDTOToStudent (SubStudentDTO subStudentDTO) {
        if (subStudentDTO == null) {
            return null;
        }

        Student student = new Student();
        student.setStudies(subStudentDTO.getStudies());

        return student;
    }

    public static SubStudentDTO studentToSubStudentDTO (Student student) {
        if (student == null) {
            return null;
        }

        SubStudentDTO subStudentDTO = new SubStudentDTO();
        subStudentDTO.setStudies(student.getStudies());

        return subStudentDTO;
    }
}
