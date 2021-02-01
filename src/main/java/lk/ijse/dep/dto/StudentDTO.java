package lk.ijse.dep.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-02-01
 **/
@Data @AllArgsConstructor @NoArgsConstructor
public class StudentDTO implements Serializable {
    int id;
    String studentName;
    String addressNo;
    String addressLine1;
    String addressLine2;
    Gender gender;
    Date dob;
    String contact;
}
