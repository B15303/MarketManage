package net.togogo.servlet;

import net.togogo.bean.Smbms_Provider;
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

@WebServlet("/selectprovider")
public class SelectProviderServlet extends HttpServlet {
    //按照输入的供应商名称查询，并将返回的数据发送至页面
    ManageService manageService = new ManageServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String ProName = req.getParameter("name");

        List<Smbms_Provider> providerList = null;
        try {
            providerList = manageService.getProByName(ProName);
            req.setAttribute("providerList",providerList);
            req.getRequestDispatcher("providerList.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
