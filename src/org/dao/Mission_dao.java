package org.dao;

import org.model.Mission;

import java.util.List;

public interface Mission_dao {
    List<Mission> queryAll();
    void addMission(Mission mission);
    void editMission(Mission mission, String id);
    void delMission(String id);
}
