package org.dao;

import org.model._Record;

import java.util.List;

public interface Record_dao {
    List<_Record> queryAll();
    void addRecord(_Record record);
    void editRecord(_Record record,String id);
    void delRecord(String id);
}
