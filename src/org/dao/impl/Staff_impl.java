package org.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.ctrl.DBCtrl;
import org.dao.Staff_dao;
import org.model.Staff;

import java.sql.SQLException;
import java.util.List;

public class Staff_impl implements Staff_dao {

    private QueryRunner qr = DBCtrl.getRunner();
    @Override
    public List<Staff> queryAll() {
        String sql = "select * from staff";
        try {
            return qr.query(sql,new BeanListHandler<>(Staff.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addStaff(Staff staff) {

    }

    @Override
    public void editStaff(Staff staff) {

    }

    @Override
    public void delStaff(String id) {

    }

    public Staff Login(String account,String pwd){
        String sql = "select * from staff where staff_account = ? and staff_password = ?";
        try {
            return qr.query(sql,new BeanHandler<>(Staff.class),account,pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
