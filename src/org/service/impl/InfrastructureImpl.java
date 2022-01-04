package org.service.impl;

import org.dao.Infrastructure_dao;
import org.factory.BeanFactory;
import org.model.Infrastructure;
import org.service.IInfrastructure;

public class InfrastructureImpl implements IInfrastructure {

    Infrastructure_dao i_d = BeanFactory.getInstance("i_d",Infrastructure_dao.class);
    @Override
    public void Add(Infrastructure i) {
        i_d.addInfrastructure(i);
    }

    @Override
    public void Edit(Infrastructure i, String id) {
        i_d.editInfrastructure(i,id);
    }

    @Override
    public void Del(String id) {
        i_d.delInfrastructure(id);
    }
}
