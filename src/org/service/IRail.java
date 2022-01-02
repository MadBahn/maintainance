package org.service;

import org.model.Rail;

public interface IRail {
    void Add(Rail r);
    void Del(String id);
    void Edit(Rail r,String id);

}
