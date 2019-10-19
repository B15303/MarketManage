package net.togogo.dao;

import net.togogo.bean.Smbms_User;

import java.util.List;

public interface ManageDao {
    public List<Smbms_User> getUserAll() throws Exception;
    public int getPwdUpdate(String []param) throws Exception;
}
