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

@WebServlet("/billAdd")
public class BillAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");   //格式化时间

        String billId = req.getParameter("billId");
        String billName = req.getParameter("billName");
        String billCom = req.getParameter("billCom");
        String billNum = req.getParameter("billNum");
        String money = req.getParameter("money");

        String supplier = req.getParameter("supplier");
        String  zhifu = req.getParameter("zhifu");

        String operator = String.valueOf(session.getAttribute("userRole"));   //获取当前登录的用户的角色
        String dateTime = df.format(LocalDateTime.now());  //当前时间

//        String providerId = req.getParameter("providerId");

        String []param = {billId,billName,billCom,billNum,money,supplier,zhifu,operator,dateTime};

        /*System.out.println(billId);
        System.out.println(billName);
        System.out.println(billCom);
        System.out.println(billNum);
        System.out.println(money);
        System.out.println(supplier);
        System.out.println(zhifu);*/

        ManageService manageService = new ManageServiceImpl();
        try {
            int count = manageService.getBillAdd(param);

            if(count != 0) {
                System.out.println("添加订单成功");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("providerList?bill=true").forward(req,resp);
    }
}
