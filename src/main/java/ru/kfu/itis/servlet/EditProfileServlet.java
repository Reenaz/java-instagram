package ru.kfu.itis.servlet;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import ru.kfu.itis.dao.PostDAO;
import ru.kfu.itis.dao.SubscriberDAO;
import ru.kfu.itis.dao.UserDAO;
import ru.kfu.itis.entity.Post;
import ru.kfu.itis.entity.User;

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

        String email = getStringFromReqPart(req.getPart("email"));
        String password = null;
        if(getStringFromReqPart(req.getPart("newPassword")) == null || getStringFromReqPart(req.getPart("newPassword")).equals("")) {
            password = DigestUtils.md5Hex(getStringFromReqPart(req.getPart("password")));
        } else{
            password = DigestUtils.md5Hex(getStringFromReqPart(req.getPart("newPassword")));
        }

        String description = getStringFromReqPart(req.getPart("description"));
        String name = getStringFromReqPart(req.getPart("name"));
        int gender = Integer.parseInt(getStringFromReqPart(req.getPart("gender")));
        int type = Integer.parseInt(getStringFromReqPart(req.getPart("type")));
        String phoneNumber = getStringFromReqPart(req.getPart("phoneNumber"));

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

    public static String getStringFromReqPart(Part part) {
        String str = "";
        if (part != null) {
            try {
                InputStream in = part.getInputStream();
                str = IOUtils.toString(in);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return str;
    }

}
