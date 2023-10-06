package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.BlogDao;
import model.User;
import model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    ObjectMapper mapper = new ObjectMapper();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        resp.setContentType("application/json;charset=utf8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ("".equals(username) || "".equals(password) || username == null || password == null) {
            resp.getWriter().write("账户名或者密码没有填写!");
        }
        UserDao userDao = new UserDao();
        User user = new User();
        user = userDao.selectByUsername(username);
        //查询用户是否存在
        if (user == null) {
            resp.getWriter().write("账户名或密码输入错误!");
        }
        if (!password.equals(user.getPassword())) {
            resp.getWriter().write("账户名或密码输入错误!");
        }
        //使用session保存用户信息
        //登录成功就创建会话,使用该会话保存用户信息
        HttpSession session = req.getSession(true);
        session.setAttribute("user",user);
        //进行重定向,跳转到博客列表页
        resp.sendRedirect("blog_list.html");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf8");

        HttpSession session = req.getSession(false);
        if (session == null) {
            User user = new User();
            mapper.writeValue(resp.getWriter(),user);
            return;
        }
        User user = (User) session.getAttribute("user");
        if (user == null) {
            user = new User();
            mapper.writeValue(resp.getWriter(),user);
            return;
        }
        //确定拿出了对象,就直接返回即可
        UserDao userDao = new UserDao();
        user = userDao.selectById(user.getUserId());
        mapper.writeValue(resp.getWriter(),user);
    }
}
