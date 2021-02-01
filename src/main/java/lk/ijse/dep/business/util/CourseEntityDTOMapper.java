package lk.ijse.dep.business.util;
import lk.ijse.dep.dto.CourseDTO;
import lk.ijse.dep.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CourseEntityDTOMapper {

    CourseEntityDTOMapper instance = Mappers.getMapper(CourseEntityDTOMapper.class);

    Course getCourse(CourseDTO dto);

    List<CourseDTO> getCourseDTOs(List<Course> courses);

}
