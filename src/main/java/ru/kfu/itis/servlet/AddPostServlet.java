package ru.kfu.itis.servlet;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kfu.itis.dao.AbstractDAO;
import ru.kfu.itis.dao.PostDAO;
import ru.kfu.itis.entity.Post;
import ru.kfu.itis.entity.User;
import ru.kfu.itis.util.MultipartRequestUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import java.io.*;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;

@MultipartConfig
public class AddPostServlet extends HttpServlet {
    private final static Logger LOG = LoggerFactory.getLogger(AddPostServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("/jsp/addPost.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = ((User) req.getSession().getAttribute("auth"));
        System.out.println(user);
        int userId = user.getId();
        String description = MultipartRequestUtil.getStringFromReqPart(req.getPart("description"));
        String location = MultipartRequestUtil.getStringFromReqPart(req.getPart("location"));

        Part photoPart = req.getPart("photo");
        InputStream in = photoPart.getInputStream();
        String basicPath = System.getProperty("user.home") + "\\java-instagram\\media\\";
        String pathToFile = user.getUserName() + "\\posts\\" + photoPart.getSubmittedFileName();

        String imgType = (photoPart.getContentType().split("/")[1]);
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

        String photoUrl = pathToFile;

        Post post = new Post(
                userId,
                photoUrl,
                description,
                location,
                null,
                0
        );

        PostDAO postDAO = new PostDAO();
        postDAO.add(post);

        resp.sendRedirect("/");
    }

}
