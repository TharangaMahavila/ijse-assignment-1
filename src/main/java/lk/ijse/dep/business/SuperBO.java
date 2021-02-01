package lk.ijse.dep.business;

import javax.persistence.EntityManager;

/**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-02-01
 **/
public interface SuperBO {
    void setEntityManager(EntityManager em);
}
