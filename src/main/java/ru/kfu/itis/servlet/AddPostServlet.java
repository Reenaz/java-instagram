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
        req.getRequestDispatcher("/jsp/addPost.jsp").forward(req, resp);
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
        String basicPath = System.getProperty("user.home") + "\\java-instagram\\media\\";
        String pathToFile = user.getUserName() + "\\posts\\" + photoPart.getSubmittedFileName();
        //System.out.println("path = " +path);
        /*File file = new File(path, photoPart.getSubmittedFileName());
*/
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

        System.out.println(pathToFile);
        String photoUrl = pathToFile;

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
