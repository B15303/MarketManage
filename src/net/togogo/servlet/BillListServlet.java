package net.togogo.servlet;

import net.togogo.bean.Smbms_Bill;
import net.togogo.service.ManageService;
import net.togogo.service.impl.ManageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/billList")
public class BillListServlet extends HttpServlet {
    ManageService manageService = new ManageServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //进入billList页面，查询所有账单数据并展示到billList页面

        try {
            //查询所有账单数据
            List<Smbms_Bill> billList = manageService.getBillAll();
            //将账单数据放入request域中
            req.setAttribute("billList",billList);
            //发送到billList页面
            req.getRequestDispatcher("/billList.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
