package ru.kfu.itis.servlet;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import ru.kfu.itis.dao.UserDAO;
import ru.kfu.itis.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

/**
 * Created by Reenaz on 16.11.2017.
 */

@MultipartConfig
public class EditProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/editProfile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String email = req.getParameter("email");

        String password = null;
        if(req.getParameter("newPassword") == null) {
            password = DigestUtils.md5Hex(req.getParameter("password"));
        } else{
            password = DigestUtils.md5Hex(req.getParameter("newPassword"));
        }

        String description = req.getParameter("decription");
        String name = req.getParameter("name");
        int gender = Integer.parseInt(req.getParameter("gender"));
        int type = Integer.parseInt(req.getParameter("type"));
        String phoneNumber = req.getParameter("phoneNumber");

        User user = new User(
                userName,
                email,
                password,
                description,
                name,
                phoneNumber,
                gender,
                type,
                null
        );
        UserDAO userDAO = new UserDAO();
        userDAO.update(user);

        resp.getWriter().print("Profile was updates successful!");
        req.getRequestDispatcher("/").forward(req, resp);

    }

}
