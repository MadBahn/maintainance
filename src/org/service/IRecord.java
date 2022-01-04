package org.service;

import org.model._Record;

public interface IRecord {
    void Add(_Record r);
    void Edit(_Record r,String id);
    void Del(String id);
}
