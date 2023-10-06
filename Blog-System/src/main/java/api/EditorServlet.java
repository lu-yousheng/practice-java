package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Blog;
import model.BlogDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit")
public class EditorServlet extends HttpServlet {
    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        resp.setContentType("application/json;charset=utf8");

        //检查请求是否有blogId
        String blogId = req.getParameter("blogId");
        if (blogId == null || Integer.parseInt(blogId) <= 0) {
            resp.getWriter().write("编写的博客异常");
            return;
        }

        //通过blogId查询博客信息
        BlogDao blogDao = new BlogDao();
        Blog blog = blogDao.selectById(Integer.parseInt(blogId));
        if (blog == null) {
            resp.getWriter().write("博客不存在");
            return;
        }
        //将博客信息返回
        objectMapper.writeValue(resp.getWriter(),blog);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        resp.setContentType("application/json;charset=utf8");

        //先判断是query string是否有blogId字段
        String blogId = req.getParameter("blogId");
        if (blogId == null || Integer.parseInt(blogId) <=0) {
            resp.getWriter().write("请先发布你的博客!");
            return;
        }
        //拿到blogId后,先找到blog数据并修改
        BlogDao blogDao = new BlogDao();
        Blog blog = blogDao.selectById(Integer.parseInt(blogId));
        blog.setTitle(req.getParameter("title"));
        blog.setContent(req.getParameter("content"));

        blogDao.modifyBlog(blog);
        resp.sendRedirect("blog_list.html");
    }
}
