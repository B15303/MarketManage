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

@WebServlet("/providerUpdate")
public class ProviderUpdateServlet extends HttpServlet {
    ManageService manageService = new ManageServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String modify = req.getParameter("modify");

        try {
            Smbms_Provider provider = manageService.getProById(id);
            req.setAttribute("provider",provider);
            req.setAttribute("modify",modify);
            req.getRequestDispatcher("providerAdd.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
