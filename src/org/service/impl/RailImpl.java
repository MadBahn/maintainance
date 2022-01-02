package org.service.impl;

import org.dao.Rail_dao;
import org.factory.BeanFactory;
import org.model.Rail;
import org.service.IRail;

public class RailImpl implements IRail {

    Rail_dao rd = BeanFactory.getInstance("rd",Rail_dao.class);
    @Override
    public void Add(Rail r) {
        rd.addRail(r);
    }

    @Override
    public void Del(String id) {
        rd.delRail(id);
    }

    @Override
    public void Edit(Rail r,String id) {
        rd.editRail(r,id);
    }
}
