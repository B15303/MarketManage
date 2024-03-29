package net.togogo.servlet;

import net.togogo.service.ManageService;
import net.togogo.service.impl.ManageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/billUpdated")
public class billUpdatedServlet extends HttpServlet {
    ManageService manageService = new ManageServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");   //格式化时间

        String billId = req.getParameter("id");
        String providerId = req.getParameter("providerId"); //订单编码
        String providerName = req.getParameter("providerName");  //商品名称
        String people = req.getParameter("people");  //商品单位
        String phone = req.getParameter("phone");  //商品数量
        String address = req.getParameter("address");  //总金额
        String fax = req.getParameter("fax");  //供应商
        String zhifu = req.getParameter("zhifu");  //是否付款
        String operator = String.valueOf(session.getAttribute("userRole"));   //获取当前登录的用户的角色
        String dateTime = df.format(LocalDateTime.now());  //当前时间

        String []param = {providerId,providerName,people,phone,address,fax,zhifu,operator,dateTime,billId};

        /*System.out.println(providerId);
        System.out.println(providerName);
        System.out.println(people);
        System.out.println(phone);
        System.out.println(address);
        System.out.println(fax);
        System.out.println(zhifu);
        System.out.println(billId);*/

        try {
            int count = manageService.getBillUpdate(param);
            System.out.println("Servlet");

        } catch (Exception e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("providerList?bill=true").forward(req,resp);
    }
}
