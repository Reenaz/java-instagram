package ru.kfu.itis.servlet;

import ru.kfu.itis.dao.SubscriberDAO;
import ru.kfu.itis.dao.UserDAO;
import ru.kfu.itis.entity.Subscriber;
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
public class SubscribeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User sessionUser = (User) session.getAttribute("auth");
        UserDAO userDAO = new UserDAO();

        if( sessionUser != null && userDAO.get(sessionUser.getId()).equals(sessionUser)) {
            String userName=req.getParameter("userName");
            String action = req.getParameter("action");
            User user = userDAO.findByUserName(userName);

            System.out.println(userName);
            System.out.println(action);

            SubscriberDAO subscriberDAO = new SubscriberDAO();

            if(action.equals("add")) {
                subscriberDAO.add(new Subscriber(
                        sessionUser.getId(),
                        user.getId(),
                        null
                        )) ;

            } else{
                if (action.equals("delete")) {
                    subscriberDAO.delete(sessionUser.getId(), user.getId());
                }
            }

            resp.sendRedirect("/user?userName=" + userName);



        } else {
            resp.sendRedirect("/");
        }
    }
}
