package org.dao;

import org.model._Record;

import java.util.List;

public interface Record_dao {
    List<_Record> queryAll();
    void addRecord(Record record);
    void editRecord(Record record);
    void delRecord(String id);
}
