package org.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.ctrl.DBCtrl;
import org.dao.Record_dao;
import org.model._Record;

import java.sql.SQLException;
import java.util.List;

public class Record_impl implements Record_dao {

    private QueryRunner qr = DBCtrl.getRunner();
    @Override
    public List<_Record> queryAll() {
        String sql = "select * from record";
        try {
            return qr.query(sql,new BeanListHandler<>(_Record.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addRecord(Record record) {

    }

    @Override
    public void editRecord(Record record) {

    }

    @Override
    public void delRecord(String id) {

    }
}
