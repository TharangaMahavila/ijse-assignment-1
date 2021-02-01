package lk.ijse.dep.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-02-01
 **/
@Data @AllArgsConstructor @NoArgsConstructor
public class Address implements Serializable {
    private String no;
    private String addressLine1;
    private String addressLine2;
    private String city;
}
