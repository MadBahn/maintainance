package org.service.impl;

import org.dao.Record_dao;
import org.factory.BeanFactory;
import org.model._Record;
import org.service.IRecord;

public class RecordImpl implements IRecord {

    private Record_dao rd = BeanFactory.getInstance("rd",Record_dao.class);
    @Override
    public void Add(_Record r) {
        rd.addRecord(r);
    }

    @Override
    public void Edit(_Record r, String id) {
        rd.editRecord(r,id);
    }

    @Override
    public void Del(String id) {
        rd.delRecord(id);
    }
}
