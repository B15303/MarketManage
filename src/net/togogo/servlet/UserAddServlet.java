package net.togogo.servlet;

import net.togogo.service.ManageService;
import net.togogo.service.impl.ManageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userAdd")
public class UserAddServlet extends HttpServlet {
    ManageService manageService = new ManageServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userCode = req.getParameter("userId");
        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userpassword");
        String gender = req.getParameter("gender");
        String birthday = req.getParameter("data");
        String phone = req.getParameter("userphone");
        String address = req.getParameter("userAddress");
        String userRole = req.getParameter("userlei");
        String []param = {userCode,userName,userPassword,gender,birthday,phone,address,userRole};

        try {
            int count = manageService.getUserAdd(param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("userList").forward(req,resp);
    }
}
