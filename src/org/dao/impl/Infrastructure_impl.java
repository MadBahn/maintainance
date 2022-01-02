package org.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.ctrl.DBCtrl;
import org.dao.Infrastructure_dao;
import org.model.Infrastructure;

import java.sql.SQLException;
import java.util.List;

public class Infrastructure_impl implements Infrastructure_dao {

    private QueryRunner qr = DBCtrl.getRunner();
    @Override
    public List<Infrastructure> queryAll() {
        String sql = "select * from facility";
        try {
            return qr.query(sql,new BeanListHandler<>(Infrastructure.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addInfrastructure(Infrastructure infrastructure) {

    }

    @Override
    public void editInfrastructure(Infrastructure infrastructure) {

    }

    @Override
    public void delInfrastructure(String id) {

    }
}
