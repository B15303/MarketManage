package net.togogo.servlet;

import net.togogo.service.ManageService;
import net.togogo.service.impl.ManageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    }
}
