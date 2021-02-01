package lk.ijse.dep.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-02-01
 **/
@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "register")
public class Register implements SuperEntity{
    @EmbeddedId
    private RegisterPK registerPK;
    @Column(name = "register_date")
    private Date registerDate;
    @Column(name = "register_fee")
    private BigDecimal registerFee;

    public Register(String studentId, String courseId, Date registerDate, BigDecimal registerFee) {
        this.registerPK = new RegisterPK(studentId,courseId);
        this.registerDate = registerDate;
        this.registerFee = registerFee;
    }
}
