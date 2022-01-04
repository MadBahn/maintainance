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
    public void addMission(Mission mission) {
        String sql = "insert into task values " +
                "(?,?,?)";
        try {
            qr.update(sql,mission.getTask_id(),
                    mission.getTask_content(),mission.getTask_date());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void editMission(Mission mission, String id) {
        String sql = "update task set " +
                "task_id = ?,task_content = ?,task_date = ? " +
                "where task_id = ?";
        try {
            qr.update(sql,mission.getTask_id(), mission.getTask_content(),
                    mission.getTask_date(),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delMission(String id) {
        String sql = "delete from task where task_id = ?";
        try {
            qr.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
