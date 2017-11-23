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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Reenaz on 16.11.2017.
 */
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

            PostDAO postDAO = new PostDAO();
            List<Post> posts = postDAO.getAllPostsByUserIdList(personIdList);

            Map<Integer, String> photoUrlMap= userDAO.getProfilePhotosOfUserList(personIdList);

            req.setAttribute("user", user);
            req.setAttribute("posts", posts);
            req.setAttribute("photos", photoUrlMap );
            req.getRequestDispatcher("jsp/feed.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/");
        }
    }
}
