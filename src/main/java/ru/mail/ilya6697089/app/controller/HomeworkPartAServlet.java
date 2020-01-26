package ru.mail.ilya6697089.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.mail.ilya6697089.app.service.impl.DatabaseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.invoke.MethodHandles;

public class HomeworkPartAServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public void init() {
        DatabaseServiceImpl databaseService = new DatabaseServiceImpl();

        logger.info("------------------a1: Delete tables----------------");
        databaseService.deleteExistingTables();

        logger.info("------------------a2: Create tables----------------");
        databaseService.createTables();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        logger.info("-------------------Tables created!-----------------");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<html><body>");
            out.println("Tables created!");
            out.println("</body></html>");
        }
    }

}


