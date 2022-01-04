package org.dao;

import org.model.Staff;

import java.util.List;

public interface Staff_dao {
    List<Staff> queryAll();
    void addStaff(Staff staff);
    void editStaff(Staff staff,String id,String pwd);
    void delStaff(String id);
    Staff Login(String account,String pwd);
    void editPwd(Staff staff,String id,String pwd);
}
