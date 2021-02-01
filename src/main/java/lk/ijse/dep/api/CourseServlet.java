package lk.ijse.dep.api;

import lk.ijse.dep.business.BOFactory;
import lk.ijse.dep.business.BOTypes;
import lk.ijse.dep.business.custom.CourseBO;
import lk.ijse.dep.dto.CourseDTO;
import lk.ijse.dep.exception.HttpResponseException;
import lk.ijse.dep.exception.ResponseExceptionUtil;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-02-01
 **/
@WebServlet(name = "CourseServlet",urlPatterns = "api/v1/courses/*")
public class CourseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            super.service(req, resp);
        } catch (Throwable t) {
            ResponseExceptionUtil.handle(t, resp);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Jsonb jsonb = JsonbBuilder.create();
        final EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();
        try {
            CourseDTO dto = jsonb.fromJson(req.getReader(), CourseDTO.class);

            if (dto.getCode() == null || dto.getCode().trim().isEmpty() || dto.getDescription() == null || dto.getDescription().trim().isEmpty() || dto.getDuration() == null || dto.getDuration().trim().isEmpty() || dto.getAudience() == null) {
                throw new HttpResponseException(400, "Invalid Course details", null);
            }

            CourseBO courseBO = BOFactory.getInstance().getBO(BOTypes.COURSE);
            courseBO.setEntityManager(em);
            courseBO.saveCourse(dto);
            resp.setStatus(HttpServletResponse.SC_CREATED);
            resp.setContentType("application/json");
            resp.getWriter().println(jsonb.toJson(dto));
        } catch (SQLIntegrityConstraintViolationException exp) {
            throw new HttpResponseException(400, "Duplicate entry", exp);
        } catch (JsonbException exp) {
            throw new HttpResponseException(400, "Failed to read the JSON", exp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            em.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
