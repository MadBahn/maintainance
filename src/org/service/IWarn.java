package org.service;

import org.model.Warn;

public interface IWarn {
    void Add(Warn w);
    void Del(String id);
    void Edit(Warn w,String id);
}
