package net.togogo.servlet;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import net.togogo.bean.Smbms_User;
import net.togogo.service.ManageService;
import net.togogo.service.impl.ManageServiceImpl;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/pwdup")
public class PasswordServlet extends HttpServlet {

    ManageService manageService = new ManageServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oldPassword = req.getParameter("oldPassword"); //获取原密码
        HttpSession session = req.getSession();
        String usercode = (String) session.getAttribute("usercode");  //从session中获取用户名
        String newPassword = req.getParameter("newPassword");         //获取输入的新密码
        String []param = {newPassword,usercode};

//        System.out.println(usercode);
//        System.out.println(oldPassword);

        String flag = "true";

        try {
            //查询所有数据
            List<Smbms_User> userList = manageService.getUserAll();
            if (null != userList) {
                for (Smbms_User smbms_user : userList) {
                    if (smbms_user.getUserCode().equals(usercode) && smbms_user.getUserPassword().equals(oldPassword)) {
                        flag = "true";  //用户名密码正确
                        break;
                    } else {
                        flag = "false"; //用户名密码错误
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

//        QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());
//        String sql = "select userCode,userPassword from smbms_user";
//        String sql1 = "UPDATE smbms_user SET userPassword='" +newPassword+ "' WHERE userCode='" +usercode+ "'";
//        BeanListHandler<Smbms_User> beanListHandler = new BeanListHandler<>(Smbms_User.class);
//        List<Smbms_User> object = null;
//        try {
//            object = queryRunner.query(sql,beanListHandler);
//            if (null != object){
//                for (Smbms_User smbms_user:object){
//                    if (smbms_user.getUserCode().equals(usercode) && smbms_user.getUserPassword().equals(oldPassword)){
//                        flag = "true";
//                        break;
//                    }else {
//                        flag = "false";
//                    }
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        if ("true" == flag){ //帐号密码对则修改密码
            try {
                int count = manageService.getPwdUpdate(param);
            } catch (Exception e) {
                e.printStackTrace();
            }
            resp.sendRedirect("password.jsp");
        }else {   //错误不修改并返回原密码错误
            req.setAttribute("flag",flag);
            req.getRequestDispatcher("password.jsp").forward(req,resp);
        }
    }
}
