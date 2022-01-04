package org.service;

import org.model.Mission;

public interface IMission {
    void Add(Mission m);
    void Edit(Mission m,String id);
    void Del(String id);
}
