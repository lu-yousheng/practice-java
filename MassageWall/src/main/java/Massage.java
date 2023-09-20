import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
class Massage_List {
    public String from;
    public String to;
    public String massage;
}
@WebServlet("/Massages")
public class Massage extends HttpServlet {
    ObjectMapper mapper = new ObjectMapper();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Massage_List massageList = mapper.readValue(req.getInputStream(),Massage_List.class);
        //massageLists.add(massageList);
        save(massageList);
        resp.setStatus(200);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf8");
        List<Massage_List> massageLists = load();
        mapper.writeValue(resp.getWriter(),massageLists);
    }
    private void save(Massage_List massageList) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection= DBUtil.getConnection();
            String sql = "insert into message values(?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, massageList.from);
            statement.setString(2, massageList.to);
            statement.setString(3, massageList.massage);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(connection,statement,null);
        }
    }
    private List<Massage_List> load() {
        List<Massage_List> massageLists = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from message";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Massage_List massageList = new Massage_List();
                massageList.from = resultSet.getString("from");
                massageList.to = resultSet.getString("to");
                massageList.massage = resultSet.getString("massage");
                massageLists.add(massageList);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return massageLists;
    }
}
