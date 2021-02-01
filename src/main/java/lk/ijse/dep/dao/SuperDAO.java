package lk.ijse.dep.dao;

import javax.persistence.EntityManager;

/**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-02-01
 **/
public interface SuperDAO {
    void setEntityManager(EntityManager em);
}
