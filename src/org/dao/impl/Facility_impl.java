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
        String sql = "insert into equipment values " +
                "(?,?,?,?,?)";
        try {
            qr.update(sql,facility.getEquipment_id(),facility.getEquipment_name(),
                    facility.getEquipment_type(),facility.getEquipment_date(),
                    facility.getEquipment_price());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editFacility(Facility facility,String id) {
        String sql = "update equipment set " +
                "equipment_id = ?,equipment_name = ?," +
                "equipment_type = ?,equipment_date = ?," +
                "equipment_price = ? " +
                "where equipment_id = ?";
        try {
            qr.update(sql,facility.getEquipment_id(),facility.getEquipment_name(),
                    facility.getEquipment_type(),facility.getEquipment_date(),
                    facility.getEquipment_price(),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delFacility(String id) {
        String sql = "delete from equipment where equipment_id = ?";
        try {
            qr.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
