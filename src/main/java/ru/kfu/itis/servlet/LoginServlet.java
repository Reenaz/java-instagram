package ru.kfu.itis.servlet;

import org.apache.commons.codec.digest.DigestUtils;
import ru.kfu.itis.dao.UserDAO;
import ru.kfu.itis.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("auth");
        UserDAO userDAO = new UserDAO();

        if( user != null && userDAO.get(user.getId()).equals(user)) {
            resp.sendRedirect("/profile");
        } else {
            req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        UserDAO userDAO = new UserDAO();
        User user = userDAO.findByUserName(userName);
        String passwordHex = DigestUtils.md5Hex(password);

        if( user != null && user.getPassword().equals(passwordHex)) {
            HttpSession session = req.getSession();
            session.setAttribute("auth", user);

            resp.sendRedirect("/profile");


        }else{
            req.setAttribute("error", "true");
            req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
        }
    }
}
