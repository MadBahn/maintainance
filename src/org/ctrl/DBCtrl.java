package org.ctrl;

import org.apache.commons.dbutils.QueryRunner;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

public class DBCtrl {
    private static DataSource source;
    static {
        source = new ComboPooledDataSource();
    }

    public static DataSource getSource(){
        return source;
    }

    public static QueryRunner getRunner (){
        return new QueryRunner(source);
    }
}
