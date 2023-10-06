package api;

import model.User;
import model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signup")
public class signUp extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        resp.setContentType("application/json;charset=utf8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username == null || "".equals(username) || password == null || "".equals(password)) {
            resp.getWriter().write("没有填写密码或者用户名!");
            return;
        }

        UserDao userDao = new UserDao();
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        userDao.userAdd(user);
        resp.sendRedirect("login.html");
    }
}
