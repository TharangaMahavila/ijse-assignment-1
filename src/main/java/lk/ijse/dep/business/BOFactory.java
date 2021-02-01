package lk.ijse.dep.business;

import lk.ijse.dep.business.custom.impl.CourseBOimpl;
import lk.ijse.dep.business.custom.impl.StudentBOimpl;

/**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-02-01
 **/
public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {

    }

    public static BOFactory getInstance() {
        return (boFactory != null) ? boFactory : (boFactory = new BOFactory());
    }

    public <T extends SuperBO> T getBO(BOTypes boType) {
        switch (boType) {
            case COURSE:
                return (T) new CourseBOimpl();
            case STUDENT:
                return (T) new StudentBOimpl();
            default:
                return null;
        }
    }
}
