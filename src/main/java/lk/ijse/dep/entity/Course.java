package lk.ijse.dep.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-02-01
 **/
@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "course")
public class Course implements SuperEntity{
    @Id
    private String code;
    private String description;
    private String duration;
    private Audience audience;
}
