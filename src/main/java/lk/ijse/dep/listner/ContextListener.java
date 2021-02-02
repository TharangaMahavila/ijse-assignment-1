package lk.ijse.dep.listner; /**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-02-01
 **/

import lk.ijse.dep.dto.Address;
import lk.ijse.dep.dto.Gender;
import lk.ijse.dep.dto.StudentDTO;
import lk.ijse.dep.util.JPAUtil;
import org.slf4j.LoggerFactory;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@WebListener()
public class ContextListener implements ServletContextListener{
    org.slf4j.Logger logger = LoggerFactory.getLogger(ContextListener.class);

    public ContextListener() {

    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        Properties prop = new Properties();
        try {
            logger.info("EntityManagerFactory is being initialized");
            sce.getServletContext().setAttribute("emf", JPAUtil.getEntityManagerFactory());

            String logFilePath;
            if (prop.getProperty("app.log_dir") != null) {
                logFilePath = prop.getProperty("app.log_dir") + "/back-end.log";
            } else {
                logFilePath = System.getProperty("catalina.home") + "/logs/back-end.log";
            }
            FileHandler fileHandler = new FileHandler(logFilePath, true);
            fileHandler.setFormatter(new SimpleFormatter());
            fileHandler.setLevel(Level.INFO);
            Logger.getLogger("").addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
        StudentDTO studentDTO = new StudentDTO(1, "Tharanga",
                new Address("01", "Arachchihena", "Ahangama", "Galle"),
                Gender.MALE, new Date(), "077-1234567");
        Jsonb jsonb = JsonbBuilder.create();
        System.out.println(jsonb.toJson(studentDTO));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        JPAUtil.getEntityManagerFactory().close();
        logger.info("EntityManagerFactory is being shut down");
    }
}
