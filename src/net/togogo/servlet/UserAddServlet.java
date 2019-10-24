package net.togogo.servlet;

import net.togogo.service.ManageService;
import net.togogo.service.impl.ManageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/userAdd")
public class UserAddServlet extends HttpServlet {
    ManageService manageService = new ManageServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");   //格式化时间

        String userCode = req.getParameter("userId");
        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userpassword");
        String gender = req.getParameter("gender");
        String birthday = req.getParameter("data");
        String phone = req.getParameter("userphone");
        String address = req.getParameter("userAddress");
        String userRole = req.getParameter("userlei");
        String modify = req.getParameter("modify");
        String id = req.getParameter("id");
        String operator = String.valueOf(session.getAttribute("userRole"));   //获取当前登录的用户的角色
        String dateTime = df.format(LocalDateTime.now());  //当前时间
        String []param = {userCode,userName,userPassword,gender,birthday,phone,address,userRole,operator,dateTime};

        if (!modify.equals("true")){
        try {
            int count = manageService.getUserAdd(param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        }else {
            String []param1 = {userCode,userName,userPassword,gender,birthday,phone,address,userRole,operator,dateTime,id};
            try {
                int count = manageService.getUserUpdate(param1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        req.getRequestDispatcher("userList").forward(req,resp);
    }
}
