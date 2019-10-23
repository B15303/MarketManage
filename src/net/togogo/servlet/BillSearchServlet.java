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
import java.util.List;

@WebServlet("/billSearch")
public class BillSearchServlet extends HttpServlet {
    ManageService manageService = new ManageServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String shangpin = req.getParameter("shangpin");
        String tigong = req.getParameter("tigong");
        String fukuan = req.getParameter("fukuan");
        System.out.println(shangpin);
        System.out.println(tigong);
        System.out.println(fukuan);

        List<Smbms_Bill> bills = null;
        try {
            bills = manageService.getBillByCondition(shangpin,tigong,fukuan);
            for (Smbms_Bill bill:bills){
                System.out.println(bill);
            }
            List<Smbms_Provider> providerList = manageService.getProviderAll();
            //将数据存入request中
            req.setAttribute("providerList",providerList);

            req.setAttribute("billList",bills);
            req.getRequestDispatcher("/billList.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
