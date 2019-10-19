package net.togogo.servlet;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import net.togogo.bean.Smbms_User;
import net.togogo.service.ManageService;
import net.togogo.service.impl.ManageServiceImpl;
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

@WebServlet("/user")
public class LoginUserServlet extends HttpServlet {

    ManageService manageService = new ManageServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean flag = true;
        //AJAX异步请求查询用户名是否存在
        String userName = req.getParameter("userName");

        try {
            //查询所有数据
            List<Smbms_User> userList = manageService.getUserAll();
            if (null != userList) {
                for (Smbms_User smbms_user : userList) {
                    if (smbms_user.getUserCode().equals(userName)) {
                        flag = true;  //用户名存在
                        break;
                    } else {
                        flag = false; //用户名不存在
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
//        QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());
//        String sql = "select * from smbms_user";
//        BeanListHandler<Smbms_User> beanListHandler = new BeanListHandler<>(Smbms_User.class);
//        try {
//            List<Smbms_User> object = queryRunner.query(sql,beanListHandler);
//            if (null != object){
//                for (Smbms_User smbms_user:object){
//                    if (smbms_user.getUserCode().equals(userName)){ //用户名存在
//                        flag = true;
//                        break;
//                    }else {  //用户名不存在
//                        flag = false;
//                    }
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        resp.getWriter().print(flag);//返回判断结果到页面
    }
}
