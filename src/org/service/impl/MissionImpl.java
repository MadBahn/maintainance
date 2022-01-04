package org.service.impl;

import org.dao.Mission_dao;
import org.factory.BeanFactory;
import org.model.Mission;
import org.service.IMission;

public class MissionImpl implements IMission {

    Mission_dao md = BeanFactory.getInstance("md",Mission_dao.class);
    @Override
    public void Add(Mission m) {
        md.addMission(m);
    }

    @Override
    public void Edit(Mission m, String id) {
        md.editMission(m,id);
    }

    @Override
    public void Del(String id) {
        md.delMission(id);
    }
}
