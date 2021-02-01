package lk.ijse.dep.business.custom;

import lk.ijse.dep.business.SuperBO;
import lk.ijse.dep.dto.CourseDTO;

import java.util.List;

/**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-02-01
 **/
public interface CourseBO extends SuperBO {

    public void saveCourse(CourseDTO courseDTO) throws Exception;

    public void updateCourse(CourseDTO courseDTO) throws Exception;

    public void deleteCourse(String courseId) throws Exception;

    public List<CourseDTO> findAllCourses() throws Exception;

}
