package org.service;

import org.model.Facility;

public interface IFacility {
    void Add(Facility f);
    void Edit(Facility f,String id);
    void Del(String id);
}
