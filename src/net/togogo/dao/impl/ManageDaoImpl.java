package net.togogo.dao.impl;

import net.togogo.bean.Smbms_Bill;
import net.togogo.bean.Smbms_Provider;
import net.togogo.bean.Smbms_User;
import net.togogo.dao.ManageDao;
import net.togogo.utils.C3p0Utils;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.ArrayList;
import java.util.List;

public class ManageDaoImpl implements ManageDao {
    @Override
    public int getPwdUpdate(String[] param) throws Exception {

        String sql = "UPDATE smbms_user SET userPassword= ? WHERE userCode= ? ";

        int count = C3p0Utils.ProUpdate(sql,param);
        return count;
    }

    @Override
    public List<Smbms_Bill> getBillAll() throws Exception {

        String sql = "select * from smbms_bill";

        BeanListHandler<Smbms_Bill> beanListHandler = new BeanListHandler<>(Smbms_Bill.class);
        List<Smbms_Bill> billList = C3p0Utils.BeanListHandlers(sql,beanListHandler);
        return billList;
    }

    @Override
    public List<Smbms_User> getUserAll() throws Exception {

        String sql = "select * from smbms_user";

        BeanListHandler<Smbms_User> beanListHandler = new BeanListHandler<>(Smbms_User.class);
        List<Smbms_User> userList = C3p0Utils.BeanListHandlers(sql,beanListHandler);
        return userList;
    }

    @Override
    public List<Smbms_Provider> getProviderAll() throws Exception {

        String sql = "select * from smbms_provider";

        BeanListHandler<Smbms_Provider> beanListHandler = new BeanListHandler<>(Smbms_Provider.class);
        List<Smbms_Provider> providerList = C3p0Utils.BeanListHandlers(sql,beanListHandler);
        return providerList;
    }

    @Override
    public Smbms_Provider getProById(String proId) throws Exception {

        String sql = "select * from smbms_provider where id = ?";
        Object []param = {proId};
        BeanHandler<Smbms_Provider> beanHandler = new BeanHandler<>(Smbms_Provider.class);
        Smbms_Provider smbms_provider = (Smbms_Provider)C3p0Utils.getBeanHandlers(sql,beanHandler, param);
        return smbms_provider;
    }

    @Override
    public List<Smbms_User> getUserByName(String Name) throws Exception {

        String sql = "SELECT * FROM `smbms_user` WHERE userName LIKE '%"+ Name +"%'";
        BeanListHandler<Smbms_User> beanListHandler = new BeanListHandler<>(Smbms_User.class);
        List<Smbms_User> userList = C3p0Utils.BeanListHandlers(sql,beanListHandler);
        return userList;
    }

    @Override
    public List<Smbms_Provider> getProByName(String ProName) throws Exception {

        String sql = "SELECT * FROM `smbms_provider` WHERE proName LIKE '%"+ ProName +"%'";
        BeanListHandler<Smbms_Provider> beanListHandler = new BeanListHandler<>(Smbms_Provider.class);
        List<Smbms_Provider> providerList = C3p0Utils.BeanListHandlers(sql,beanListHandler);
        return providerList;
    }

    @Override
    public Smbms_User getUserById(String userId) throws Exception {

        String sql = "select * from smbms_user where id = ?";
        Object []param = {userId};
        BeanHandler<Smbms_User> beanHandler = new BeanHandler<>(Smbms_User.class);
        Smbms_User smbms_user = (Smbms_User)C3p0Utils.getBeanHandlers(sql,beanHandler, param);
        return smbms_user;
    }

    @Override
    public Smbms_Bill getBillById(String billId) throws Exception {

        String sql = "select * from smbms_bill where id = ?";
        Object []param = {billId};
        BeanHandler<Smbms_Bill> beanHandler = new BeanHandler<>(Smbms_Bill.class);
        Smbms_Bill smbms_bill = (Smbms_Bill)C3p0Utils.getBeanHandlers(sql,beanHandler, param);
        return smbms_bill;
    }

    @Override
    public int getProviderAdd(String[] param) throws Exception {

        String sql = "INSERT INTO " +
                     "smbms_provider (proCode,proName,proContact,proPhone,proAddress,proFax,proDesc,createdBy,creationDate) " +
                     "VALUES (?,?,?,?,?,?,?,?,?)";
        int count = C3p0Utils.ProUpdate(sql,param);
        return count;
    }

    @Override
    public int getUserAdd(String[] param) throws Exception {

        String sql = "INSERT INTO " +
                "smbms_user (userCode,userName,userPassword,gender,birthday,phone,address,userRole,createdBy,creationDate) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?)";
        int count = C3p0Utils.ProUpdate(sql,param);
        return count;
    }

    @Override
    public int getBillDelete(String billId) throws Exception {
        String sql = "delete from smbms_bill where id = ?";
        int count = C3p0Utils.ProUpdate(sql,billId);
        return count;
    }

    @Override
    public int getProDelete(String proId) throws Exception {
        String sql = "delete from smbms_provider where id = ?";
        int count = C3p0Utils.ProUpdate(sql,proId);
        return count;
    }

    @Override
    public int getUserDelete(String userId) throws Exception {
        String sql = "delete from smbms_user where id = ?";
        int count = C3p0Utils.ProUpdate(sql,userId);
        return count;
    }

    @Override
    public int getUserUpdate(String[] param) throws Exception {

        String sql = "UPDATE smbms_user SET userCode= ?,userName = ?,userPassword = ?," +
                     "gender = ?,birthday = ?,phone = ?,address = ?,userRole = ?,modifyBy = ?," +
                     "modifyDate = ? WHERE id= ? ";

        int count = C3p0Utils.ProUpdate(sql,param);
        return count;
    }

    @Override
    public int getBillAdd(String[] param) throws Exception {
        String sql = "insert into smbms_bill " +
                     "(billCode,productName,productUnit,productCount,totalPrice,providerId,isPayment,createdBy,creationDate)" +
                     " value(?,?,?,?,?,?,?,?,?)";
        int count = C3p0Utils.ProUpdate(sql,param);

        return count;
    }

    @Override
    public int getBillUpdate(String[] param) throws Exception {
        String sql = "UPDATE smbms_bill SET billCode = ?,productName = ?,productUnit = ?," +
                     "productCount = ?,totalPrice = ?,providerId = ?,isPayment = ?,modifyBy = ?,modifyDate = ?" +
                     " WHERE id= ? ";
        int count = C3p0Utils.ProUpdate(sql,param);
        return count;
    }

    @Override
    public int getProUpdate(String[] param) throws Exception {

        String sql = "UPDATE smbms_provider SET proCode = ?,proName = ?,proContact = ?," +
                     "proPhone = ?,proAddress = ?,proFax = ?,proDesc = ?,modifyBy = ?,modifyDate = ? " +
                     "WHERE id= ? ";

        int count = C3p0Utils.ProUpdate(sql,param);
        return count;
    }

    @Override
    public List<Smbms_Bill> getBillByCondition(String productName, String providerId, String isPayment) {

        String sql = "select * from smbms_bill where 1=1";
        List<String>list = new ArrayList<>();

        if (productName != null && !productName.equals("")) {
            sql = sql + " and productName like ?";
            list.add("%"+productName+"%");
        }

        if (providerId != null && !providerId.equals("")){
            sql = sql + " and providerId = ?";
            list.add(providerId);
        }

        if (isPayment != null && !isPayment.equals("")){
            sql = sql + " and isPayment = ?";
            list.add(isPayment);
        }

        BeanListHandler<Smbms_Bill> beanListHandler = new BeanListHandler<>(Smbms_Bill.class);
        List<Smbms_Bill> bills = C3p0Utils.BeanListHandlers(sql,beanListHandler,list.toArray());

        return bills;
    }
}
