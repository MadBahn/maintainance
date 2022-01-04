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
        String sql = "insert into facility values " +
                "(?,?,?,?,?)";
        try {
            qr.update(sql,infrastructure.getFacility_id(),infrastructure.getFacility_name(),
                    infrastructure.getFacility_state(), infrastructure.getFacility_type(),
                    infrastructure.getFacility_remark());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editInfrastructure(Infrastructure infrastructure,String id) {
        String sql = "update facility set facility_id = ?,facility_name = ?," +
                "facility_state = ?,facility_type = ?,facility_remark = ? " +
                "where facility_id = ?";
        try {
            qr.update(sql,infrastructure.getFacility_id(),infrastructure.getFacility_name(),
                    infrastructure.getFacility_state(), infrastructure.getFacility_type(),
                    infrastructure.getFacility_remark(),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delInfrastructure(String id) {
        String sql = "delete from facility where facility_id = ?";
        try {
            qr.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
