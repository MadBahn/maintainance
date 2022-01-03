package org.service.impl;

import org.dao.Warning_dao;
import org.factory.BeanFactory;
import org.model.Warn;
import org.service.IWarn;

public class WarnImpl implements IWarn {

    Warning_dao wd = BeanFactory.getInstance("wd",Warning_dao.class);
    @Override
    public void Add(Warn w) {
        wd.addWarn(w);
    }

    @Override
    public void Del(String id) {
        wd.delWarn(id);
    }

    @Override
    public void Edit(Warn w, String id) {
        wd.editWarn(w,id);
    }
}
