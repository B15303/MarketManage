package net.togogo.servlet;

import net.togogo.bean.Smbms_Provider;
import net.togogo.service.ManageService;
import net.togogo.service.impl.ManageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/billGetProvider")
public class BillGetProvider extends HttpServlet {
    ManageService manageService = new ManageServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("进入获取供应商");
        try {
            List<Smbms_Provider> providerList = manageService.getProviderAll();

            System.out.println(providerList);

            req.setAttribute("providerList",providerList);
        } catch (Exception e) {
            e.printStackTrace();
        }



        req.getRequestDispatcher("billAdd.jsp").forward(req,resp);
    }
}
