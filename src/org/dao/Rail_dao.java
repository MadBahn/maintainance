package org.dao;

import org.model.Rail;

import java.util.List;

public interface Rail_dao {
    List<Rail> queryAll();
    void addRail(Rail rail);
    void editRail(Rail rail,String id);
    void delRail(String id);
}
