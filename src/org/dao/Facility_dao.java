package org.dao;

import org.model.Facility;

import java.util.List;

public interface Facility_dao {
    List<Facility> queryAll();
    void addFacility(Facility facility);
    void editFacility(Facility facility,String id);
    void delFacility(String id);
}
