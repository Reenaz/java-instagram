package ru.kfu.itis.servlet;

import com.google.gson.Gson;
import ru.kfu.itis.dao.SubscriberDAO;
import ru.kfu.itis.dao.UserDAO;
import ru.kfu.itis.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class GetSubscribersServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User sessionUser = (User) session.getAttribute("auth");
        UserDAO userDAO = new UserDAO();
        User user = userDAO.get(sessionUser.getId());

        System.out.println("yeeeee");

        if(user.equals(sessionUser)) {
            SubscriberDAO subscriberDAO = new SubscriberDAO();

            List<User> subList = subscriberDAO.getAllSubscribers(user.getId()).stream().map(subId -> {
                return userDAO.get(subId);
            }).collect(Collectors.toList());

            String json = new Gson().toJson(subList);

            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(json);

        } else {
            resp.sendRedirect("/");
        }
    }
}
