package org.test;

import org.dao.impl.Mission_impl;
import org.dao.impl.Warn_impl;
import org.model.Mission;
import org.model.Warn;

import java.util.List;

public class run {
    public static void main(String[] args) {
        Mission_impl mi = new Mission_impl();
        List<Mission> ml = mi.queryAll();
        for (Mission i :ml){
            System.out.println(i);
        }
        Warn_impl wi = new Warn_impl();
        List<Warn> wl = wi.queryAll();
        for (Warn i : wl){
            System.out.println(i);
        }
    }
}
