package net.togogo.servlet;

import net.togogo.bean.Smbms_User;
import net.togogo.dao.ManageDao;
import net.togogo.dao.impl.ManageDaoImpl;
import net.togogo.service.ManageService;
import net.togogo.service.impl.ManageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectuser")
public class SelectUserServlet extends HttpServlet {
    //查询符合条件的用户数据，并发送到页面
    ManageService manageService = new ManageServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String Name = req.getParameter("name");
//        System.out.println(Name);

        try {
            List<Smbms_User> userList = manageService.getUserByName(Name);
//            System.out.println(userList);
            req.setAttribute("userList",userList);
            req.getRequestDispatcher("userList.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
