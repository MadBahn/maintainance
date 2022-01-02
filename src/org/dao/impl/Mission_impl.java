package org.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.ctrl.DBCtrl;
import org.dao.Mission_dao;
import org.model.Mission;

import java.sql.SQLException;
import java.util.List;

public class Mission_impl implements Mission_dao {

    private QueryRunner qr = DBCtrl.getRunner();
    @Override
    public List<Mission> queryAll() {
        String sql = "select * from task";
        try {
            return qr.query(sql,new BeanListHandler<>(Mission.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addStaff(Mission mission) {

    }

    @Override
    public void editStaff(Mission mission) {

    }

    @Override
    public void delStaff(Mission mission) {

    }
}
