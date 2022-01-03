package org.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.ctrl.DBCtrl;
import org.dao.Warning_dao;
import org.model.Warn;

import java.sql.SQLException;
import java.util.List;

public class Warn_impl implements Warning_dao {
    QueryRunner qr = DBCtrl.getRunner();
    @Override
    public List<Warn> queryAll() {
        String sql = "select * from warn";
        try {
            return qr.query(sql,new BeanListHandler<>(Warn.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addWarn(Warn warn) {
        String sql = "insert into warn values" +
                "(?,?,?,?,?)";
        try {
            qr.update(sql,warn.getWarn_id(),warn.getWarn_grade(),
                    warn.getWarn_content(),warn.getWarn_validtime(),
                    warn.getWarn_date());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editWarn(Warn warn,String id) {
        String sql = "update warn set " +
                "warn_id = ?,warn_grade = ?,warn_content = ?," +
                "warn_validtime = ?,warn_date = ? " +
                "where warn_id = ?";
        try {
            qr.update(sql,warn.getWarn_id(),warn.getWarn_grade(),
                    warn.getWarn_content(),warn.getWarn_validtime(),
                    warn.getWarn_date(),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delWarn(String id) {
        String sql = "delete from warn where warn_id = ?";
        try {
            qr.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
