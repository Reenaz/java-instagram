package ru.kfu.itis.servlet;

import org.apache.commons.io.IOUtils;
import ru.kfu.itis.dao.PostDAO;
import ru.kfu.itis.entity.Post;
import ru.kfu.itis.entity.User;

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
import java.sql.SQLException;

/**
 * Created by Reenaz on 16.11.2017.
 */
@MultipartConfig
public class AddPostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/addPost.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = ((User) req.getSession().getAttribute("auth"));
        System.out.println(user);
        int userId = user.getId();
        String description = getStringFromReqPart(req.getPart("description"));
        String location = getStringFromReqPart(req.getPart("location"));

        Part photoPart = req.getPart("photo");
        InputStream in = photoPart.getInputStream();
        String userName = user.getUserName();
        String path = System.getProperty("user.home") + "\\java-instagram\\" + userName + "\\";
        System.out.println("path = " +path);
        String imgType = (photoPart.getContentType().split("/")[1]);
        File file = new File(path + userName + "_post_" + photoPart.getSubmittedFileName());
        File dir = file.getParentFile();
        if(!file.exists())
        {
            dir.mkdir();
        }
        file.createNewFile();
        OutputStream out = new FileOutputStream(file);
        IOUtils.copy(in, out); //The function is below
        out.flush();
        out.close();

        String photoUrl = file.getAbsolutePath();

        Post post = new Post(
                userId,
                photoUrl,
                description,
                location
        );

        PostDAO postDAO = new PostDAO();
        postDAO.add(post);

        resp.sendRedirect("/");
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
