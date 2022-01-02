package org.dao;

import org.model.Infrastructure;

import java.util.List;

public interface Infrastructure_dao {
    List<Infrastructure> queryAll();
    void addInfrastructure(Infrastructure infrastructure);
    void editInfrastructure(Infrastructure infrastructure);
    void delInfrastructure(String id);
}
