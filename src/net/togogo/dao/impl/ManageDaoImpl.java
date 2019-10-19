package net.togogo.dao.impl;

import net.togogo.bean.Smbms_User;
import net.togogo.dao.ManageDao;
import net.togogo.utils.C3p0Utils;
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
    public List<Smbms_User> getUserAll() throws Exception {

        String sql = "select * from smbms_user";

        BeanListHandler<Smbms_User> beanListHandler = new BeanListHandler<>(Smbms_User.class);
        List<Smbms_User> userList = C3p0Utils.BeanListHandlers(sql,beanListHandler);
        return userList;
    }
}
