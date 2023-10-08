import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //验证用户名密码是否正确
        //正常情况下,用户名密码使用数据库来处保存的
        //此处约定用户名和密码合法的只有一个
        if (username.equals("zhangsan") || username.equals("lisi")) {
            //if (password)
        }
    }
}
