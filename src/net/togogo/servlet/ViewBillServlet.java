package net.togogo.servlet;

import net.togogo.bean.Smbms_Bill;
import net.togogo.bean.Smbms_Provider;
import net.togogo.service.ManageService;
import net.togogo.service.impl.ManageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/billView")
public class ViewBillServlet extends HttpServlet {
    ManageService manageService = new ManageServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        try {
            Smbms_Bill smbms_bill = manageService.getBillById(id);
            String proId = String.valueOf(smbms_bill.getProviderId()); //强转int为String
            Smbms_Provider smbms_provider = manageService.getProById(proId);
            req.setAttribute("bill",smbms_bill);
            req.setAttribute("provider",smbms_provider);
            req.getRequestDispatcher("billView.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
