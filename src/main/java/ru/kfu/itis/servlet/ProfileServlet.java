package ru.kfu.itis.servlet;

import ru.kfu.itis.dao.PostDAO;
import ru.kfu.itis.dao.SubscriberDAO;
import ru.kfu.itis.entity.Post;
import ru.kfu.itis.entity.Subscriber;
import ru.kfu.itis.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.List;

public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("auth");

        PostDAO postDAO = new PostDAO();
        List<Post> posts = postDAO.findByUserId(user.getId());

        SubscriberDAO subscriberDAO = new SubscriberDAO();
        int countOfSubscribers = subscriberDAO.getCountOfSubscribers(user.getId());
        int countOfSigningPerson = subscriberDAO.getCountOfPersonToSub(user.getId());

        req.setAttribute("user", user);
        req.setAttribute("userName", user.getUserName());
        if (!posts.isEmpty()) req.setAttribute("posts", posts);
        req.setAttribute("countOfPosts", posts.size());
        req.setAttribute("subscribersCount", countOfSubscribers);
        req.setAttribute("countOfSignPerson", countOfSigningPerson);

        req.getRequestDispatcher("/jsp/profile.jsp").forward(req, resp);
        /*resp.getWriter().print(user.toString());
        resp.getWriter().append(posts.toString());*/
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
