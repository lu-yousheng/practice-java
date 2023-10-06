package api;

import model.Blog;
import model.BlogDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/blog")
public class BlogServlet extends HttpServlet {
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BlogDao blogDao = new BlogDao();
        String blogId = req.getParameter("blogId");
        if (blogId == null) {
            List<Blog> blogList = new ArrayList<>();
            blogList = blogDao.selectAll();
            resp.setContentType("application/json;charset=utf8");
            objectMapper.writeValue(resp.getWriter(),blogList);
        }else {
            Blog blog = blogDao.selectById(Integer.parseInt(blogId)) ;
            if (blog == null) {
                resp.getWriter().write("你要访问的博客不存在!");
            }
            resp.setContentType("application/json;charset=utf8");
            objectMapper.writeValue(resp.getWriter(),blog);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        resp.setContentType("application/json;charset=utf8");
        if (session == null) {
            resp.getWriter().write("当前未登录!");
            return;
        }
        User user = (User) session.getAttribute("user");
        if (user == null) {
            resp.getWriter().write("当前未登录!");
            return;
        }
        req.setCharacterEncoding("utf8");
        String title= req.getParameter("title");
        String content = req.getParameter("content");
        if ("".equals(title) || title == null || content == null || "".equals(content)) {
            resp.getWriter().write("标题或正文为空!");
            return;
        }

        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);
        blog.setPostTime(new Timestamp(System.currentTimeMillis()));
        blog.setUserId(user.getUserId());
        BlogDao blogDao = new BlogDao();
        blogDao.add(blog);

        resp.sendRedirect("blog_list.html");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        resp.setContentType("application/json;charset=utf8");

        String blogId = req.getParameter("blogId");
        BlogDao blogDao = new BlogDao();
        blogDao.delete(Integer.parseInt(blogId));
        resp.sendRedirect("blog_list.html");
    }
}
