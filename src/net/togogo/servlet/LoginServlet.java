package net.togogo.servlet;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import net.togogo.bean.Smbms_User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String flag = "true";

        String userName = req.getParameter("userName");
        String pwd = req.getParameter("password");

        QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());
        String sql = "select * from smbms_user";
        BeanListHandler<Smbms_User> beanListHandler = new BeanListHandler<>(Smbms_User.class);
        try {
            List<Smbms_User> object = queryRunner.query(sql,beanListHandler);
            if (null != object){
                for (Smbms_User smbms_user:object){
                    if (smbms_user.getUserCode().equals(userName) && smbms_user.getUserPassword().equals(pwd)){
                        flag = "true";  //用户名密码正确
                        HttpSession session = req.getSession();
                        session.setAttribute("UserName",smbms_user.getUserName());
                        session.setAttribute("usercode",smbms_user.getUserCode());

                        break;
                    }else {
                        flag = "false"; //用户名密码错误
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if ("true" == flag){
            resp.sendRedirect("index.jsp");
        }else {
            req.setAttribute("flag",flag);
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }
}
