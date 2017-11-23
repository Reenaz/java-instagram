package ru.kfu.itis.servlet;

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

            CommentDAO commentDAO = new CommentDAO();
            commentDAO.delete(commentId);

            resp.sendRedirect("feed");
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


            CommentDAO commentDAO = new CommentDAO();
            commentDAO.add(new Comment(
                    postId,
                    sessionUser.getId(),
                    commentTxt,
                    null
            ));

            resp.sendRedirect("/feed");


        } else{
            resp.sendRedirect("/");
        }
    }
}
