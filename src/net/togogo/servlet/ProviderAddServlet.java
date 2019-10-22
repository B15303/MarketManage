package net.togogo.servlet;

import net.togogo.service.ManageService;
import net.togogo.service.impl.ManageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/proAdd")
public class ProviderAddServlet extends HttpServlet {
    ManageService manageService = new ManageServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String proCode = req.getParameter("providerId");
        String proName = req.getParameter("providerName");
        String proContact = req.getParameter("contact");
        String proPhone = req.getParameter("phone");
        String proAddress = req.getParameter("address");
        String proFax = req.getParameter("fax");
        String proDesc = req.getParameter("describe");
        String modify = req.getParameter("modify");
        String id = req.getParameter("id");
        String []param = {proCode,proName,proContact,proPhone,proAddress,proFax,proDesc};

        if (!modify.equals("true")){
        try {
            int count = manageService.getProviderAdd(param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        }else {
            String []param1 = {proCode,proName,proContact,proPhone,proAddress,proFax,proDesc,id};
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
