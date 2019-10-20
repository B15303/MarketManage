package net.togogo.dao.impl;

import net.togogo.bean.Smbms_Bill;
import net.togogo.bean.Smbms_Provider;
import net.togogo.bean.Smbms_User;
import net.togogo.dao.ManageDao;
import net.togogo.utils.C3p0Utils;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

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
}
