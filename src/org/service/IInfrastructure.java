package org.service;

import org.model.Infrastructure;

public  interface IInfrastructure {
    void Add(Infrastructure i);
    void Edit(Infrastructure i,String id);
    void Del(String id);
}
