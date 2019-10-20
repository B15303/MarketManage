package net.togogo.dao;

import net.togogo.bean.Smbms_Bill;
import net.togogo.bean.Smbms_Provider;
import net.togogo.bean.Smbms_User;

import java.util.List;

public interface ManageDao {
    public List<Smbms_User> getUserAll() throws Exception;
    public int getPwdUpdate(String []param) throws Exception;
    public List<Smbms_Bill> getBillAll() throws Exception;
    public List<Smbms_Provider> getProviderAll() throws Exception;
    public Smbms_Provider getProById(String proId) throws Exception;
}
