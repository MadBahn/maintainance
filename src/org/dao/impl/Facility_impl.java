package org.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.ctrl.DBCtrl;
import org.dao.Facility_dao;
import org.model.Facility;

import java.sql.SQLException;
import java.util.List;

public class Facility_impl implements Facility_dao {

    private QueryRunner qr = DBCtrl.getRunner();
    @Override
    public List<Facility> queryAll() {
        String sql = "select * from equipment";
        try {
            return qr.query(sql,new BeanListHandler<>(Facility.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addFacility(Facility facility) {

    }

    @Override
    public void editFacility(Facility facility) {

    }

    @Override
    public void delFacility(String id) {

    }
}
