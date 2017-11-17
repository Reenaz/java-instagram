package ru.kfu.itis.filter;

import ru.kfu.itis.dao.UserDAO;
import ru.kfu.itis.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Reenaz on 15.11.2017.
 */
public class AuthFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        HttpSession session = req.getSession();

        if( session == null ) {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else{
            User user = (User) session.getAttribute("user");
            UserDAO userDAO = new UserDAO();
            if(userDAO.get(user.getId()) != user || user == null) {
                session.invalidate();
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }
        }
    }

    public void destroy() {

    }
}
