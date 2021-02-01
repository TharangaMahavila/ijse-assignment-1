package lk.ijse.dep.business.util;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentEntityDTOMapper {

    StudentEntityDTOMapper instance = Mappers.getMapper(StudentEntityDTOMapper.class);

}
