package ru.kfu.itis.servlet;

import com.google.gson.Gson;
import ru.kfu.itis.dao.CommentDAO;
import ru.kfu.itis.dao.UserDAO;
import ru.kfu.itis.entity.Comment;
import ru.kfu.itis.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Reenaz on 23.11.2017.
 */
public class CommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User sessionUser = (User) session.getAttribute("auth");
        UserDAO userDAO = new UserDAO();

        if( sessionUser != null && userDAO.get(sessionUser.getId()).equals(sessionUser)) {
            int commentId = Integer.parseInt(req.getParameter("commentId"));
            int postId = Integer.parseInt(req.getParameter("postId"));

            CommentDAO commentDAO = new CommentDAO();
            commentDAO.delete(commentId);

            resp.sendRedirect("feed#" + postId);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User sessionUser = (User) session.getAttribute("auth");
        UserDAO userDAO = new UserDAO();

        if( sessionUser != null && userDAO.get(sessionUser.getId()).equals(sessionUser)) {
            String commentTxt = req.getParameter("comment");
            int postId = Integer.parseInt(req.getParameter("postId"));
            System.out.println(commentTxt);
            System.out.println(postId);

            if(commentTxt != null && !commentTxt.trim().equals("") ) {
                CommentDAO commentDAO = new CommentDAO();
                int commentId = commentDAO.add(new Comment(
                        postId,
                        sessionUser.getId(),
                        commentTxt,
                        null
                ));

                System.out.println("comment id " + commentId);

                Map<String, String> respMap = new HashMap<>();

                respMap.put("comment_id", String.valueOf(commentId));
                respMap.put("user_name", sessionUser.getUserName());

                String json = new Gson().toJson(respMap);

                //String json = new Gson().toJson(commentId, sessionUser.getId())

                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(json);
                //resp.getWriter().write(json);


            }

            //resp.sendRedirect("/feed#" + postId);


        } else{
            resp.sendRedirect("/");
        }
    }
}
