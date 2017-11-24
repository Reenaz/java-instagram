package ru.kfu.itis.servlet;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kfu.itis.dao.AbstractDAO;
import ru.kfu.itis.dao.PostDAO;
import ru.kfu.itis.dao.SubscriberDAO;
import ru.kfu.itis.dao.UserDAO;
import ru.kfu.itis.entity.Post;
import ru.kfu.itis.entity.User;
import ru.kfu.itis.util.MultipartRequestUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;


@MultipartConfig
public class EditProfileServlet extends HttpServlet {
    private final static Logger LOG = LoggerFactory.getLogger(AbstractDAO.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("auth");
        UserDAO userDAO = new UserDAO();

        if( user != null && userDAO.get(user.getId()).equals(user)) {
            req.setAttribute("user", user);
            req.getRequestDispatcher("jsp/editProfile.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User sessionUser = (User) session.getAttribute("auth");

        String email = MultipartRequestUtil.getStringFromReqPart(req.getPart("email"));
        String password = null;
        if(MultipartRequestUtil.getStringFromReqPart(req.getPart("newPassword")) == null || MultipartRequestUtil.getStringFromReqPart(req.getPart("newPassword")).equals("")) {
            password = DigestUtils.md5Hex(MultipartRequestUtil.getStringFromReqPart(req.getPart("password")));
        } else{
            password = DigestUtils.md5Hex(MultipartRequestUtil.getStringFromReqPart(req.getPart("newPassword")));
        }

        String description = MultipartRequestUtil.getStringFromReqPart(req.getPart("description"));
        String name = MultipartRequestUtil.getStringFromReqPart(req.getPart("name"));
        int gender = Integer.parseInt(MultipartRequestUtil.getStringFromReqPart(req.getPart("gender")));
        int type = Integer.parseInt(MultipartRequestUtil.getStringFromReqPart(req.getPart("type")));
        String phoneNumber = MultipartRequestUtil.getStringFromReqPart(req.getPart("phoneNumber"));

        Part photoPart = req.getPart("photo");
        String photoUrl = sessionUser.getPhoto();
        if(!photoPart.getSubmittedFileName().equals("")) {
            InputStream in = photoPart.getInputStream();
            String basicPath = System.getProperty("user.home") + "\\java-instagram\\media\\";
            String pathToFile = sessionUser.getUserName() + "\\profile_photo\\" + photoPart.getSubmittedFileName();
            File file = new File(basicPath + pathToFile);
            File dir = file.getParentFile();
            if(false == file.exists())
            {
                dir.mkdirs();
            }
            file.createNewFile();
            OutputStream out = new FileOutputStream(file);
            IOUtils.copy(in, out); //The function is below
            out.flush();
            out.close();

            photoUrl = pathToFile;
        }

        User user = new User(
                sessionUser.getUserName(),
                email,
                password,
                description,
                name,
                phoneNumber,
                gender,
                type,
                photoUrl
        );
        UserDAO userDAO = new UserDAO();
        userDAO.update(user);
        User userWithId = userDAO.findByUserName(user.getUserName());


        req.getSession().invalidate();
        req.getSession().setAttribute("auth", userWithId);

        resp.sendRedirect("profile");

    }


}
