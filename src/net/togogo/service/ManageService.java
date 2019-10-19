package net.togogo.service;

import net.togogo.bean.Smbms_User;

import java.util.List;

public interface ManageService {
    public List<Smbms_User> getUserAll() throws Exception;
    public int getPwdUpdate(String []param) throws Exception;
}
