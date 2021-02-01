package lk.ijse.dep.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-02-01
 **/
@Data @AllArgsConstructor
@NoArgsConstructor
public class CourseDTO implements Serializable {
    private String code;
    private String description;
    private String duration;
    private Audience audience;
}
