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
        String sql = "insert into staff values" +
                "(?,?,?,?,?,?,?)";
        try {
            qr.update(sql,staff.getStaff_id(),staff.getStaff_name(),
                    staff.getStaff_account(),staff.getStaff_password(),
                    staff.getStaff_position(),staff.getStaff_phone(),
                    staff.getStaff_email());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void editStaff(Staff staff,String id,String pwd) {
        String sql = "update staff set staff_phone = ?," +
                "staff_email = ? where staff_id = ? and " +
                "staff_password = ?";
        try {
            qr.update(sql,staff.getStaff_phone(),
                    staff.getStaff_email(),
                    id,pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delStaff(String id) {
        String sql = "delete from staff where staff_id = ?";
        try {
            qr.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    @Override
    public void editPwd(Staff staff, String id,String pwd) {
        String sql = "update staff set staff_account = ?," +
                "staff_password = ? where staff_id = ? and " +
                "staff_password = ?";
        try {
            qr.update(sql,staff.getStaff_account(),
                    staff.getStaff_password(),
                    id,pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
