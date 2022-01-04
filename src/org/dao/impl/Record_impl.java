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
    public void addRecord(_Record record) {
        String sql = "insert into record values " +
                "(?,?,?,?,?,?)";
        try {
            qr.update(sql,record.getRecord_id(),record.getRecord_date(),
                    record.getRecord_content(),record.getFacility_id(),
                    record.getEquipment_id(),record.getRail_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editRecord(_Record record,String id) {
        String sql = "update record set record_id = ?,record_date = ?," +
                "record_content = ? where record_id = ?";
        try {
            qr.update(sql,record.getRecord_id(),record.getRecord_date(),
                    record.getRecord_content(),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delRecord(String id) {
        String sql = "delete from record where record_id = ?";
        try {
            qr.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
