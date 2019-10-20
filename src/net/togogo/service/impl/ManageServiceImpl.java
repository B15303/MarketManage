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
}
