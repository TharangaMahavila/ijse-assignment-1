package lk.ijse.dep.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-02-01
 **/
@Data @AllArgsConstructor @NoArgsConstructor
@Embeddable
public class RegisterPK implements Serializable {
    @Column(name = "student_id")
    private String studentId;
    @Column(name = "course_id")
    private String courseId;
}
