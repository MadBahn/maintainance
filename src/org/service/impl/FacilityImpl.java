package org.service.impl;

import org.dao.Facility_dao;
import org.factory.BeanFactory;
import org.model.Facility;
import org.service.IFacility;

public class FacilityImpl implements IFacility {

    Facility_dao fd = BeanFactory.getInstance("fd",Facility_dao.class);
    @Override
    public void Add(Facility f) {
        fd.addFacility(f);
    }

    @Override
    public void Edit(Facility f, String id) {
        fd.editFacility(f,id);
    }

    @Override
    public void Del(String id) {
        fd.delFacility(id);
    }
}
