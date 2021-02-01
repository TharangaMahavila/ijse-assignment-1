package lk.ijse.dep.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-02-01
 **/
@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "student")
public class Student implements SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    int id;
    @Column(name = "student_name")
    private
    String studentName;
    @Embedded
    private
    Address address;
    private Gender gender;
    private Date dob;
    private String contact;
}
