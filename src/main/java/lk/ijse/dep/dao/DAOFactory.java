package lk.ijse.dep.dao;

import lk.ijse.dep.dao.custom.impl.CourseDAOimpl;
import lk.ijse.dep.dao.custom.impl.QueryDAOimpl;
import lk.ijse.dep.dao.custom.impl.StudentDAOimpl;

/**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-02-01
 **/
public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){

    }

    public static DAOFactory getInstance(){
        return (daoFactory != null)? daoFactory: (daoFactory = new DAOFactory());
    }

    public <T extends SuperDAO> T getDAO(DAOTypes daoType){
        switch (daoType){
            case COURSE:
                return (T) new CourseDAOimpl();
            case STUDENT:
                return (T) new StudentDAOimpl();
            case QUERY:
                return (T) new QueryDAOimpl();
            default:
                return null;
        }
    }
}
