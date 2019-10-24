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

@WebServlet("/billUpdate")
public class billUpdateServlet extends HttpServlet {

    ManageService manageService = new ManageServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        try {
            Smbms_Bill Bill = manageService.getBillById(id);

            List<Smbms_Provider> Providers = manageService.getProviderAll();

            req.setAttribute("Bill",Bill);
            req.setAttribute("Providers",Providers);

        } catch (Exception e) {
            e.printStackTrace();
        }


        req.getRequestDispatcher("billUpdate.jsp").forward(req,resp);
    }
}
