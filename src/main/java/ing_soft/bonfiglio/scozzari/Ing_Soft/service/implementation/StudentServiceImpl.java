package ing_soft.bonfiglio.scozzari.Ing_Soft.service.implementation;

import ing_soft.bonfiglio.scozzari.Ing_Soft.model.Student;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.StudentRepository;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces.StudentService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) throws Exception {
        //if(studentRepository.findById(student.getId()).isEmpty()){
            studentRepository.save(student);
        //} else {
            //throw new Exception("exception");
        //}
        return student;
    }
}
