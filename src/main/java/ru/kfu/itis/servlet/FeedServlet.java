package ru.kfu.itis.servlet;

import javafx.geometry.Pos;
import ru.kfu.itis.dao.*;
import ru.kfu.itis.entity.Comment;
import ru.kfu.itis.entity.Post;
import ru.kfu.itis.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

public class FeedServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("auth");
        UserDAO userDAO = new UserDAO();

        if( user != null && userDAO.get(user.getId()).equals(user)) {
            SubscriberDAO subscriberDAO = new SubscriberDAO();
            List<Integer> personIdList = subscriberDAO.getAllPersonIdOfSub(user.getId());
            personIdList.add(user.getId());

            List<Post> posts = new LinkedList<>();
            Map<Integer, User> users = new HashMap<>();

            PostDAO postDAO = new PostDAO();
            for(int userId : personIdList) {
                posts.addAll(postDAO.getAllPostsByUserId(userId));
                users.put(userId, userDAO.get(userId));
            }

            CommentDAO commentDAO = new CommentDAO();

            Map<Integer, String> commentUserNameMap = new HashMap<>();
            Map<Integer, String> likeMap = new HashMap<>();

            for(Post post : posts) {
                List<Comment> comments = commentDAO.getCommentsByPostId(post.getId());

                LikeDAO likeDAO = new LikeDAO();

                if(likeDAO.get(user.getId(), post.getId()) != null) {
                    likeMap.put(post.getId(), "like");
                } else {
                    likeMap.put(post.getId(), "unlike");
                }

                for(Comment comment : comments) {
                    commentUserNameMap.put(comment.getId(), userDAO.get(comment.getUserId()).getUserName());
                }

                post.setComments(comments);
            }


            req.setAttribute("likeMap", likeMap);
            req.setAttribute("commentUserNameMap", commentUserNameMap);
            req.setAttribute("user", user);
            req.setAttribute("posts", posts);
            req.setAttribute("users", users );
            req.getRequestDispatcher("jsp/feed.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/");
        }
    }
}
