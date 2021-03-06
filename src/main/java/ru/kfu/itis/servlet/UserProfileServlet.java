package ru.kfu.itis.servlet;

import ru.kfu.itis.dao.PostDAO;
import ru.kfu.itis.dao.SubscriberDAO;
import ru.kfu.itis.dao.UserDAO;
import ru.kfu.itis.entity.Post;
import ru.kfu.itis.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User authUser = (User) req.getSession().getAttribute("auth");
        UserDAO userDAO = new UserDAO();

        if (authUser == null || !userDAO.get(authUser.getId()).equals(authUser)) {
            resp.sendRedirect("/");
        } else {
            String userName = req.getParameter("userName");
            User user = userDAO.findByUserName(userName);

            if(user.equals(authUser)) {
                resp.sendRedirect("/profile");
            } else {
                    PostDAO postDAO = new PostDAO();
                    List<Post> posts = postDAO.findByUserId(user.getId());


                    SubscriberDAO subscriberDAO = new SubscriberDAO();
                    if(subscriberDAO.isSubscribed(authUser.getId(), user.getId()) != 0) {
                        req.setAttribute("isSubscribed", "true");
                    } else {
                        req.setAttribute("isSubscribed", "false");
                    }


                    int countOfSubscribers = subscriberDAO.getCountOfSubscribers(user.getId());
                    int countOfSigningPerson = subscriberDAO.getCountOfPersonToSub(user.getId());

                    req.setAttribute("user", user);
                    req.setAttribute("posts", posts);
                    req.setAttribute("access", "true");

                    if (!posts.isEmpty()) req.setAttribute("posts", posts);
                    req.setAttribute("countOfPosts", posts.size());
                    req.setAttribute("subscribersCount", countOfSubscribers);
                    req.setAttribute("countOfSignPerson", countOfSigningPerson);

                    req.getRequestDispatcher("/jsp/user.jsp").forward(req, resp);
            }
        }
    }

}
