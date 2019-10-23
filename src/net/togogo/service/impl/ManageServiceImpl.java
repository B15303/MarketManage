package net.togogo.service.impl;

import net.togogo.bean.Smbms_Bill;
import net.togogo.bean.Smbms_Provider;
import net.togogo.bean.Smbms_User;
import net.togogo.dao.ManageDao;
import net.togogo.dao.impl.ManageDaoImpl;
import net.togogo.service.ManageService;

import java.util.List;

public class ManageServiceImpl implements ManageService {

    ManageDao manageDao = new ManageDaoImpl();

    @Override
    public List<Smbms_User> getUserAll() throws Exception {
        return manageDao.getUserAll();
    }

    @Override
    public int getPwdUpdate(String[] param) throws Exception {
        return manageDao.getPwdUpdate(param);
    }

    @Override
    public List<Smbms_Bill> getBillAll() throws Exception {
        return manageDao.getBillAll();
    }

    @Override
    public List<Smbms_Provider> getProviderAll() throws Exception {
        return manageDao.getProviderAll();
    }

    @Override
    public Smbms_Provider getProById(String proId) throws Exception {
        return manageDao.getProById(proId);
    }

    @Override
    public List<Smbms_User> getUserByName(String Name) throws Exception {
        return manageDao.getUserByName(Name);
    }

    @Override
    public List<Smbms_Provider> getProByName(String ProName) throws Exception {
        return manageDao.getProByName(ProName);
    }

    @Override
    public Smbms_User getUserById(String userId) throws Exception {
        return manageDao.getUserById(userId);
    }

    @Override
    public Smbms_Bill getBillById(String billId) throws Exception {
        return manageDao.getBillById(billId);
    }

    @Override
    public int getProviderAdd(String[] param) throws Exception {
        return manageDao.getProviderAdd(param);
    }

    @Override
    public int getUserAdd(String[] param) throws Exception {
        return manageDao.getUserAdd(param);
    }

    @Override
    public int getBillDelete(String billId) throws Exception {
        return manageDao.getBillDelete(billId);
    }

    @Override
    public int getProDelete(String proId) throws Exception {
        return manageDao.getProDelete(proId);
    }

    @Override
    public int getUserDelete(String userId) throws Exception {
        return manageDao.getUserDelete(userId);
    }

    @Override
    public int getUserUpdate(String[] param) throws Exception {
        return manageDao.getUserUpdate(param);
    }

    @Override
    public int getBillAdd(String[] param) throws Exception {
        return manageDao.getBillAdd(param);
    }

    @Override
    public int getBillUpdate(String[] param) throws Exception {
        return manageDao.getBillUpdate(param);
    }


    @Override
    public int getProUpdate(String[] param) throws Exception {
        return manageDao.getProUpdate(param);
    }

    @Override
    public List<Smbms_Bill> getBillByCondition(String productName, String providerId, String isPayment) {
        return manageDao.getBillByCondition(productName, providerId, isPayment);
    }
}
