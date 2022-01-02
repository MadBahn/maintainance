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

    }

    @Override
    public void editWarn(Warn warn) {

    }

    @Override
    public void delWarn(String id) {

    }
}
