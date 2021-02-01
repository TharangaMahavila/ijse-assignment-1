package lk.ijse.dep.business.util;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import lk.ijse.dep.dto.Audience;
import lk.ijse.dep.dto.CourseDTO;
import lk.ijse.dep.entity.Course;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-02-01T17:49:57+0530",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_261 (Oracle Corporation)"
)
public class CourseEntityDTOMapperImpl implements CourseEntityDTOMapper {

    @Override
    public Course getCourse(CourseDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Course course = new Course();

        course.setCode( dto.getCode() );
        course.setDescription( dto.getDescription() );
        course.setDuration( dto.getDuration() );
        course.setAudience( audienceToAudience( dto.getAudience() ) );

        return course;
    }

    @Override
    public List<CourseDTO> getCourseDTOs(List<Course> courses) {
        if ( courses == null ) {
            return null;
        }

        List<CourseDTO> list = new ArrayList<CourseDTO>( courses.size() );
        for ( Course course : courses ) {
            list.add( courseToCourseDTO( course ) );
        }

        return list;
    }

    protected lk.ijse.dep.entity.Audience audienceToAudience(Audience audience) {
        if ( audience == null ) {
            return null;
        }

        lk.ijse.dep.entity.Audience audience1;

        switch ( audience ) {
            case AFTER_AL: audience1 = lk.ijse.dep.entity.Audience.AFTER_AL;
            break;
            case UNDERGRADUATE: audience1 = lk.ijse.dep.entity.Audience.UNDERGRADUATE;
            break;
            case GRADUATE: audience1 = lk.ijse.dep.entity.Audience.GRADUATE;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + audience );
        }

        return audience1;
    }

    protected Audience audienceToAudience1(lk.ijse.dep.entity.Audience audience) {
        if ( audience == null ) {
            return null;
        }

        Audience audience1;

        switch ( audience ) {
            case AFTER_AL: audience1 = Audience.AFTER_AL;
            break;
            case UNDERGRADUATE: audience1 = Audience.UNDERGRADUATE;
            break;
            case GRADUATE: audience1 = Audience.GRADUATE;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + audience );
        }

        return audience1;
    }

    protected CourseDTO courseToCourseDTO(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseDTO courseDTO = new CourseDTO();

        courseDTO.setCode( course.getCode() );
        courseDTO.setDescription( course.getDescription() );
        courseDTO.setDuration( course.getDuration() );
        courseDTO.setAudience( audienceToAudience1( course.getAudience() ) );

        return courseDTO;
    }
}
