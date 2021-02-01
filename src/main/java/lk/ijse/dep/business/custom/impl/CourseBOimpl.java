package lk.ijse.dep.business.custom.impl;

import lk.ijse.dep.business.custom.CourseBO;
import lk.ijse.dep.business.util.CourseEntityDTOMapper;
import lk.ijse.dep.dao.DAOFactory;
import lk.ijse.dep.dao.DAOTypes;
import lk.ijse.dep.dao.custom.CourseDAO;
import lk.ijse.dep.dto.CourseDTO;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-02-01
 **/
public class CourseBOimpl implements CourseBO {

    private final CourseDAO courseDAO;
    private EntityManager em;
    private final CourseEntityDTOMapper mapper = CourseEntityDTOMapper.instance;

    public CourseBOimpl() {
        courseDAO = DAOFactory.getInstance().getDAO(DAOTypes.COURSE);
    }

    @Override
    public void saveCourse(CourseDTO courseDTO) throws Exception {
        try {
            em.getTransaction().begin();
            courseDAO.save(mapper.getCourse(courseDTO));
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public void updateCourse(CourseDTO courseDTO) throws Exception {
        try {
            em.getTransaction().begin();
            courseDAO.update(mapper.getCourse(courseDTO));
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public void deleteCourse(String courseId) throws Exception {
        try {
            em.getTransaction().begin();
            courseDAO.delete(courseId);
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public List<CourseDTO> findAllCourses() throws Exception {
        try {
            em.getTransaction().begin();
            List<CourseDTO> customerDTOs = mapper.getCourseDTOs(courseDAO.getAll());
            em.getTransaction().commit();
            return customerDTOs;
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public void setEntityManager(EntityManager em) {
        this.em=em;
        courseDAO.setEntityManager(em);
    }
}
