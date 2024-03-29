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
    public List<Smbms_User> getUserByName(String Name) throws Exception;
    public List<Smbms_Provider> getProByName(String ProName) throws Exception;
    public Smbms_User getUserById(String userId) throws Exception;
    public Smbms_Bill getBillById(String billId) throws Exception;
    public int getProviderAdd(String []param) throws Exception;
    public int getUserAdd(String []param) throws Exception;
    public int getBillDelete(String billId) throws Exception;
    public int getProDelete(String proId) throws Exception;
    public int getProUpdate(String []param) throws Exception;
    public int getUserDelete(String userId) throws Exception;
    public int getUserUpdate(String []param) throws Exception;
    public List<Smbms_Bill> getBillByCondition(String productName,String providerId,String isPayment);
    public int getBillAdd(String[] param) throws Exception;

    public int getBillUpdate(String[] param) throws Exception;
}
