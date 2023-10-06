package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Blog;
import model.BlogDao;
import model.User;
import model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/author")
public class AuthorServlet extends HttpServlet {
    ObjectMapper mapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        resp.setContentType("application/json;charset=utf8");
        String blogId = req.getParameter("blogId");
        if (blogId == null) {
            resp.getWriter().write("当前博客不存在");
            return;
        }

        //通过blogId查询到用户并返回去
        User user = new User();
        UserDao userDao = new UserDao();
        BlogDao blogDao = new BlogDao();
        Blog blog = blogDao.selectById(Integer.parseInt(blogId));
        user = userDao.selectById(blog.getUserId());
        mapper.writeValue(resp.getWriter(),user);
    }
}
