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

@WebServlet("/providerList")
public class ProviderListServlet extends HttpServlet {
    ManageService manageService = new ManageServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //进入providerList页面，查询所有供应商的数据并显示在页面上

        try {
            //查询所有供应商
            List<Smbms_Provider> providerList = manageService.getProviderAll();
            //将数据存入request中
            req.setAttribute("providerList",providerList);
            //发送至providerList页面
            req.getRequestDispatcher("providerList.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
