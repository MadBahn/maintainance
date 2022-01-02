package org.dao;

import org.model.Warn;

import java.util.List;

public interface Warning_dao {
    List<Warn> queryAll();
    void addWarn(Warn warn);
    void editWarn(Warn warn);
    void delWarn(String id);
}
