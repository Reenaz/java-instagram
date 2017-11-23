package ru.kfu.itis.servlet;

import ru.kfu.itis.dao.LikeDAO;
import ru.kfu.itis.dao.PostDAO;
import ru.kfu.itis.dao.SubscriberDAO;
import ru.kfu.itis.dao.UserDAO;
import ru.kfu.itis.entity.Like;
import ru.kfu.itis.entity.Post;
import ru.kfu.itis.entity.Subscriber;
import ru.kfu.itis.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Reenaz on 24.11.2017.
 */
public class LikeServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User sessionUser = (User) session.getAttribute("auth");
        UserDAO userDAO = new UserDAO();

        if( sessionUser != null && userDAO.get(sessionUser.getId()).equals(sessionUser)) {
            int postId = Integer.parseInt(req.getParameter("postId"));
            String action = req.getParameter("action");
            LikeDAO likeDAO = new LikeDAO();
            PostDAO postDAO = new PostDAO();

            if(action.equals("add")) {
                likeDAO.add(new Like(
                        postId,
                        sessionUser.getId()
                )) ;

                Post post = postDAO.get(postId);
                postDAO.updateLikesCoung(postId, post.getLikesCount()+1);

            } else{
                if (action.equals("delete")) {
                    likeDAO.delete(sessionUser.getId(), postId);

                    Post post = postDAO.get(postId);
                    postDAO.updateLikesCoung(postId, post.getLikesCount()-1);
                }
            }

            resp.sendRedirect("/feed");



        } else {
            resp.sendRedirect("/");
        }
    }
}
