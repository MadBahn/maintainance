package org.dao;

import org.model.Mission;

import java.util.List;

public interface Mission_dao {
    List<Mission> queryAll();
    void addStaff(Mission mission);
    void editStaff(Mission mission);
    void delStaff(Mission mission);
}
