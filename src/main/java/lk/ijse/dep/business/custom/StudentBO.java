package lk.ijse.dep.business.custom;

import lk.ijse.dep.business.SuperBO;
import lk.ijse.dep.dto.CourseDTO;
import lk.ijse.dep.dto.StudentDTO;

import java.util.List;

/**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-02-01
 **/
public interface StudentBO extends SuperBO {
    public void saveStudent(StudentDTO studentDTO) throws Exception;

    public void updateStudent(StudentDTO studentDTO) throws Exception;

    public void deleteStudent(String studentId) throws Exception;

    public List<StudentDTO> findAllStudents() throws Exception;

    public StudentDTO findStudentById(String studentId) throws Exception;

    public List<StudentDTO> searchStudent(String key) throws Exception;
}
