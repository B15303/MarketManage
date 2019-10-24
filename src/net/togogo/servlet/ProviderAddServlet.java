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

@WebServlet("/proAdd")
public class ProviderAddServlet extends HttpServlet {
    ManageService manageService = new ManageServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");   //格式化时间

        String proCode = req.getParameter("providerId");
        String proName = req.getParameter("providerName");
        String proContact = req.getParameter("contact");
        String proPhone = req.getParameter("phone");
        String proAddress = req.getParameter("address");
        String proFax = req.getParameter("fax");
        String proDesc = req.getParameter("describe");
        String modify = req.getParameter("modify");
        String id = req.getParameter("id");
        String operator = String.valueOf(session.getAttribute("userRole"));   //获取当前登录的用户的角色
        String dateTime = df.format(LocalDateTime.now());  //当前时间


        String []param = {proCode,proName,proContact,proPhone,proAddress,proFax,proDesc,operator,dateTime};

        if (!modify.equals("true")){
        try {
            int count = manageService.getProviderAdd(param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        }else {
            String []param1 = {proCode,proName,proContact,proPhone,proAddress,proFax,proDesc,operator,dateTime,id};
            try {
                int count = manageService.getProUpdate(param1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        req.getRequestDispatcher("providerList").forward(req,resp);
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        String proCode = req.getParameter("providerId");
//        String proName = req.getParameter("providerName");
//        String proContact = req.getParameter("contact");
//        String proPhone = req.getParameter("phone");
//        String proAddress = req.getParameter("address");
//        String proFax = req.getParameter("fax");
//        String proDesc = req.getParameter("describe");
//        String []param = {proCode,proName,proContact,proPhone,proAddress,proFax,proDesc};
//
//        try {
//            int count =manageService.getProviderAdd(param);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        req.getRequestDispatcher("providerList").forward(req,resp);
//    }
}
