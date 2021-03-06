package ru.kfu.itis.servlet;

import org.apache.commons.codec.digest.DigestUtils;

import org.apache.commons.io.IOUtils;

import org.postgresql.core.Oid;
import ru.kfu.itis.dao.UserDAO;
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
public class RegistrationServlet  extends HttpServlet {

    public static byte[] getBytesFromInputStream(InputStream is) throws IOException
    {
        try (ByteArrayOutputStream os = new ByteArrayOutputStream();)
        {
            byte[] buffer = new byte[0xFFFF];

            for (int len; (len = is.read(buffer)) != -1;)
                os.write(buffer, 0, len);

            os.flush();

            return os.toByteArray();
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("auth");
        UserDAO userDAO = new UserDAO();

        if( user != null && userDAO.get(user.getId()).equals(user)) {
            resp.sendRedirect("/profile");
        } else {
            req.getRequestDispatcher("jsp/reg.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = MultipartRequestUtil.getStringFromReqPart(req.getPart("userName"));
        String email = MultipartRequestUtil.getStringFromReqPart(req.getPart("email"));
        String password = DigestUtils.md5Hex(MultipartRequestUtil.getStringFromReqPart(req.getPart("password")));
        String description = MultipartRequestUtil.getStringFromReqPart(req.getPart("descr"));
        String name = MultipartRequestUtil.getStringFromReqPart(req.getPart("name"));;
        int gender = Integer.parseInt(MultipartRequestUtil.getStringFromReqPart(req.getPart("gender")));
        int type = Integer.parseInt(MultipartRequestUtil.getStringFromReqPart(req.getPart("type")));
        String phoneNumber = MultipartRequestUtil.getStringFromReqPart(req.getPart("phoneNumber"));

        Part photoPart = req.getPart("data");
        String photoUrl = "";
        if(photoPart != null && !photoPart.getSubmittedFileName().equals("")) {
            InputStream in = photoPart.getInputStream();
            String basicPath = System.getProperty("user.home") + "\\java-instagram\\media\\";
            String pathToFile = userName + "\\profile_photo\\" + photoPart.getSubmittedFileName();
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
        } else {
            photoUrl = System.getProperty("user.home") + "\\java-instagram\\default\\default_user_img.jpg";
        }


        User user = new User(
                userName,
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
        int id = userDAO.add(user);

        resp.getWriter().print("Successful registration!");
        req.getRequestDispatcher("/").forward(req, resp);

    }

}
