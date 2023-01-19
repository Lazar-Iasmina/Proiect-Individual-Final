package com.example.demo1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCUtil {
    public List getBeans(ResultSet rs, BeanFactoryJDBC factory ) throws SQLException {
        List list = new ArrayList();
        while( rs.next() )
            list.add( factory.createBean(rs) );
        return list;
    }
}
