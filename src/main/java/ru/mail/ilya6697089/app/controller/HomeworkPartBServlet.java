package ru.mail.ilya6697089.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.mail.ilya6697089.app.service.UserService;
import ru.mail.ilya6697089.app.service.impl.UserServiceImpl;
import ru.mail.ilya6697089.app.service.model.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.invoke.MethodHandles;

public class HomeworkPartBServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String age = req.getParameter("age");

        UserDTO userDTO = new UserDTO();
        userDTO.setName(username);
        userDTO.setPassword(password);
        logger.info("--------------- b: Add users----------------");
        try {
            int ageInt = Integer.parseInt(age);
            userDTO.setAge(ageInt);
            UserDTO addedUserDTO = userService.add(userDTO);
            try (PrintWriter out = resp.getWriter()) {
                out.println("<html><body>");
                out.println(addedUserDTO);
                out.println("User  " + username + "  added in table user.");
                out.println("</body></html>");
            }
        } catch (NumberFormatException e) {
            logger.error("Uncorrect format", e);
        }

    }

}
