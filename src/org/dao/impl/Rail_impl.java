package org.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.ctrl.DBCtrl;
import org.dao.Rail_dao;
import org.model.Rail;

import java.sql.SQLException;
import java.util.List;

public class Rail_impl implements Rail_dao {

    private QueryRunner qr = DBCtrl.getRunner();
    @Override
    public List<Rail> queryAll() {
        String sql = "select * from rail";
        try {
            return qr.query(sql,new BeanListHandler<>(Rail.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addRail(Rail rail) {
        String sql = "insert into rail values(?,?,?,?,?,?,?,?,?,?)";
        try {
            qr.update(sql,
                    rail.getRail_id(),
                    rail.getRail_name(),
                    rail.getRail_grade(),
                    rail.getRail_gauge(),
                    rail.getRail_type(),
                    rail.getRail_length(),
                    rail.getRail_subgrade(),
                    rail.getRail_position(),
                    rail.getRail_electrification(),
                    rail.getRail_remark());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void editRail(Rail rail,String id) {
        String sql = "update rail " +
                "set rail_id = ?,rail_name = ?,rail_grade = ?," +
                "rail_gauge = ?,rail_type = ?,rail_length = ?," +
                "rail_subgrade = ?,rail_position = ?," +
                "rail_electrification = ?,rail_remark = ? " +
                "where rail_id = ?";
        try {
            qr.update(sql,
                    rail.getRail_id(),rail.getRail_name(),rail.getRail_grade(),
                    rail.getRail_gauge(),rail.getRail_type(),rail.getRail_length(),
                    rail.getRail_subgrade(),rail.getRail_position(),
                    rail.getRail_electrification(),rail.getRail_remark(),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delRail(String id) {
        String sql = "delete from rail where rail_id = ?";
        try {
            qr.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
